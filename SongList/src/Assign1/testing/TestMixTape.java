/**
 * 
 */
package Assign1.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Assign1.MixTape;
import Assign1.Song;


/**

 *
 */
public class TestMixTape {

	static int numPassedTests = 0;
	static Song[] songs;// = Song.testArray();

	static MixTape tapePop;
	static MixTape tapeBlank;
	static private final int NUMA = 6, NUMB = 4;  // how many songs to populate tapePop with
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		songs = Song.testArray();
		
		System.out.println("Your student ID is " + MixTape.STUDENT_ID);
		System.out.println("Edit MixTape.STUDENT_ID if the above is not correct.");
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		// create some mixtapes to test upon
		tapePop = new MixTape(60, songs,NUMA,NUMB);
		tapeBlank = new MixTape(60);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	//////////  actual test cases begin here   /////////////////////
	
	@Test
	public void testNumTracks(){
		int lenA = tapePop.numTracks('A');
		int lenB = tapePop.numTracks('B');
		int lenAB = tapePop.numTracks();
		int lenX1 = tapeBlank.numTracks('A');
		int lenX = tapeBlank.numTracks();
		int lenZ = tapePop.numTracks('Q');  
		assertTrue( (lenA==NUMA)&&(lenB==NUMB)&&(lenAB==NUMA+NUMB)&&(lenX==0)&&(lenX1==0)&&(lenZ==-1));
		//numPassedTests++;
	}

	@Test
	public void testGetTrackAt(){   //char,int  and int
		
		// test getting track from side A
		Song sideAtrack1 = tapePop.getTrackAt('A',1);
		assertEquals(sideAtrack1,songs[0]);
		
		// test getting track from side B
		Song sideBtrack1 = tapePop.getTrackAt('B',1);
		assertEquals(sideBtrack1,songs[NUMA]);
		assertEquals(sideBtrack1, tapePop.getTrackAt(NUMA+1));
		
		// test one-argument form of the method
		Song trackB1again = tapePop.getTrackAt(NUMA+1);
		assertEquals(sideBtrack1, trackB1again);
		
		// test getting a non-existent track
		Song nosong = tapePop.getTrackAt(NUMA+NUMB+9);
		assertTrue(nosong==null);
	}
	
	// the following uses getTrackAt() 
	@Test
	public void testSetTrackAt(){  //  char,int,Song  and  int,song
		// test two-argument form
		Song newTrack = songs[songs.length-1];
		boolean OK = tapePop.setTrackAt('B',3,newTrack);
		assertTrue(OK);
		assertEquals(tapePop.getTrackAt('B',3), newTrack);
		
		// test one-argument form
		newTrack = songs[songs.length-2];
		OK = tapePop.setTrackAt(NUMA+4, newTrack);
		assertTrue(OK);
		assertEquals(tapePop.getTrackAt('B',4),newTrack);
		
		// test failure:  try to add song way past the end
		newTrack = songs[songs.length-3];
		OK = tapePop.setTrackAt('A', 99, newTrack);
		assertFalse(OK);
	}

	// uses getTrackAt, numTracks
	@Test
	public void testInsertSongAtPosition(){
		// test add song to side A
		int index = NUMA+NUMB;  // first Song in songs not yet in tapePop
		Song add1 = songs[index++];
		Song firstSongA = tapePop.getTrackAt('A',1);
		Song firstSongB = tapePop.getTrackAt('B',1);
		Song secondSongB = tapePop.getTrackAt('B',2);
		boolean OK = tapePop.insertSongAtPosition('A',1,add1);
		assertTrue(OK);
		assertEquals(tapePop.getTrackAt('A',1),add1);
		assertEquals(tapePop.getTrackAt('A',2),firstSongA);
		
		// test add song to side B
		Song add2 = songs[index++];
		OK = tapePop.insertSongAtPosition('B', 2, add2);
		assertTrue(OK);
		assertEquals(tapePop.getTrackAt('B',1),firstSongB);
		assertEquals(tapePop.getTrackAt('B',2),add2);
		assertEquals(tapePop.getTrackAt('B',3),secondSongB);
		
		// add well past the end of the side to see it fail
		Song add3 = songs[index++];
		int numSongs = tapePop.numTracks('A');
		OK = tapePop.insertSongAtPosition('A',99,add3);
		assertFalse(OK);
		assertEquals(tapePop.numTracks('A'), numSongs);
		
		// could also test:
		// add to already-full side to see it fail
	}
		
	// tests timeOccupiedMinutes AND timeOccupiedSeconds
	// this assumes AddSongToEnd  *** REWRITE WITH INSERTSONGATPOSITION *******
	/*@Test
	public void testTimeOccupied(){  
		tapeBlank.addSongToEnd('A', new Song("A","a","3:50"));
		tapeBlank.addSongToEnd('A', new Song("B","b","5:55"));
		tapeBlank.addSongToEnd('B', new Song("C","c","2:30"));
		tapeBlank.addSongToEnd('B', new Song("D","d","6:05"));
		tapeBlank.addSongToEnd('B', new Song("E","e","3:55"));
		assertTrue( tapeBlank.timeOccupiedMinutes('A') == 9.75);
		assertEquals( tapeBlank.timeOccupiedSeconds('A'), 585);
		assertTrue( tapeBlank.timeOccupiedMinutes('B') == 12.5);
		assertEquals( tapeBlank.timeOccupiedSeconds('B'), 750);
	} */
	@Test
	public void testTimeOccupied(){  
		boolean OK = tapeBlank.insertSongAtPosition('A',1, new Song("A","a","3:50"));
		OK = OK & tapeBlank.insertSongAtPosition('A', 2, new Song("B","b","5:55"));
		OK = OK & tapeBlank.insertSongAtPosition('B', 1, new Song("C","c","2:30"));
		OK = OK & tapeBlank.insertSongAtPosition('B', 2, new Song("D","d","6:05"));
		OK = OK & tapeBlank.insertSongAtPosition('B', 3, new Song("E","e","3:55"));
		assertTrue(OK);
		assertTrue( tapeBlank.timeOccupiedMinutes('A') == 9.75);
		assertEquals( tapeBlank.timeOccupiedSeconds('A'), 585);
		assertTrue( tapeBlank.timeOccupiedMinutes('B') == 12.5);
		assertEquals( tapeBlank.timeOccupiedSeconds('B'), 750);
	}	
	
	
	// tests timeLeftMinutes and timeLeftSeconds
	// this assumes addSongToEnd  *** REWRITE WITH INSERTSONGATPOSITION *******
	/*@Test
	public void testTimeLeft(){
		tapeBlank.addSongToEnd('A', new Song("A","a","3:50"));
		tapeBlank.addSongToEnd('A', new Song("B","b","5:55"));
		tapeBlank.addSongToEnd('B', new Song("C","c","2:30"));
		tapeBlank.addSongToEnd('B', new Song("D","d","6:05"));
		tapeBlank.addSongToEnd('B', new Song("E","e","3:55"));
		// assuming tapeBlank was set up as 60 minutes total length
		assertTrue( tapeBlank.timeLeftMinutes('A') == 20.25);
		assertEquals( tapeBlank.timeLeftSeconds('A'), 1215);
		assertTrue( tapeBlank.timeLeftMinutes('B') == 17.5);
		assertEquals( tapeBlank.timeLeftSeconds('B'), 1050);
	} */
	@Test
	public void testTimeLeft(){
		boolean OK = tapeBlank.insertSongAtPosition('A',1, new Song("A","a","3:50"));
		OK = OK & tapeBlank.insertSongAtPosition('A',2, new Song("B","b","5:55"));
		OK = OK & tapeBlank.insertSongAtPosition('B',1, new Song("C","c","2:30"));
		OK = OK & tapeBlank.insertSongAtPosition('B',2, new Song("D","d","6:05"));
		OK = OK & tapeBlank.insertSongAtPosition('B',3, new Song("E","e","3:55"));
		// assuming tapeBlank was set up as 60 minutes total length
		assertTrue(OK);
		assertTrue( tapeBlank.timeLeftMinutes('A') == 20.25);
		assertEquals( tapeBlank.timeLeftSeconds('A'), 1215);
		assertTrue( tapeBlank.timeLeftMinutes('B') == 17.5);
		assertEquals( tapeBlank.timeLeftSeconds('B'), 1050);
	}
	
	
	// test sideIsFull and tapeIsFull
	// assumes addSongsToEnd works  *** REWRITE WITH INSERTSONGATPOSITION *******
	@Test
	public void testFullMembers(){
		// we require that the tapePop has only a few songs on each side, ie not full yet
		// If one of these three fails then the problem is with tapePop.  
		// However this should not be the case.
		assertFalse(tapePop.sideIsFull('A'));
		assertFalse(tapePop.sideIsFull('B'));
		assertFalse(tapePop.tapeIsFull());
		
		// the tape already has the first NUMA+NUMB songs, 
		// so the index of the first unused song in songs[] array is: 
		int songix = NUMA+NUMB;
		// we assume here that songs[] is larger than NUMA+NUMB,
		// i.e. the above is a valid index.

		// now insert songs into side A until it's full.
		int pos = 1;
		while(tapePop.insertSongAtPosition('A', pos++, songs[songix++])){
			// if we have reached the end of songs array, go back to first element and start
			// adding duplicates.  Easiest done by using % (remainder) to reset songix:
			songix = songix%songs.length;
		}
		
		// so side A is full, but side B is not full, and thus the tape is not full.
		assertTrue(tapePop.sideIsFull('A')); // || (songix==songs.length) );
		assertFalse(tapePop.sideIsFull('B'));
		assertFalse(tapePop.tapeIsFull());
		
		// now add songs to side B until full - this time using addToEnd()
		/*while(tapePop.addSongToEnd('B',songs[songix])){
			if (++songix==songs.length) break;
		}*/
		while(tapePop.addSongToEnd('B',songs[songix++])){
			songix = songix%songs.length;
		}
		
		// now both sides A and B are full, and thus so is the tape.
		assertTrue(tapePop.sideIsFull('A') || (songix==songs.length) );
		assertTrue(tapePop.sideIsFull('B') || (songix==songs.length) );
		assertTrue(tapePop.tapeIsFull());
	}
	
	
	// the following also uses:  numTracks, getTrackAt, timeLeftMinutes, sideIsFull
	@Test
	public void testAddSongToEnd(){
		int ntrA = tapePop.numTracks('A');
		int ntrB = tapePop.numTracks('B');
		//
		double minsLeft = tapePop.timeLeftMinutes('A');
		double mins = Double.max(0.1,minsLeft*0.8);
		Song newTrack = new Song("Test","more than half remaining time on A",mins);
	    boolean sideFull = tapePop.sideIsFull('A');
		boolean OK = tapePop.addSongToEnd(newTrack);
		// should have added to side A:
		assertTrue(OK!=sideFull);
		if(!sideFull){
			assertEquals(tapePop.numTracks('A'), ntrA+1);
			assertEquals(tapePop.getTrackAt(ntrA+1), newTrack);
		
			// adding another track of same length should add to side A, but will cause it to be full
			newTrack = new Song("Test","equally long track", mins);
			OK = tapePop.addSongToEnd(newTrack);
			// should have added to side A:
			assertTrue(OK!=sideFull);
			assertEquals(tapePop.numTracks('A'), ntrA+2);
			assertEquals(tapePop.getTrackAt(ntrA+2), newTrack);
		}
		//
		// adding another track should add to side B, provided B not already full
		//double minsLeftB = tapePop.timeLeftMinutes('B');
		newTrack = songs[songs.length-1];
		sideFull = tapePop.sideIsFull('B');
		OK = tapePop.addSongToEnd(newTrack);
		assertTrue(OK!=sideFull);
		if (!sideFull){
			assertEquals(tapePop.numTracks('B'), ntrB+1);
		}
		//
		// add a stupidly long track to see it fail.
		// adding it twice:  first will fill the side, second will fail.
		newTrack = new Song("Test","ridiculously long","99:00");
		OK = tapePop.addSongToEnd('B',newTrack);
		assertTrue(OK);
		OK = tapePop.addSongToEnd('B',newTrack);
		assertFalse(OK);
		//
		// test adding to blank tape
		newTrack = songs[0];
		OK = tapeBlank.addSongToEnd(newTrack);
		newTrack = songs[1];
		OK = OK && tapeBlank.addSongToEnd('B',newTrack);
		assertTrue(OK);
		assertEquals(tapeBlank.numTracks(),2);
		assertEquals(tapeBlank.numTracks('A'),1);
		assertEquals(tapeBlank.numTracks('B'),1);
	}


	// tests positionOnSide AND positionOnTape
	// uses getTrackAt
	@Test
	public void testPositionMembers()
	{
		Song trackA3 = tapePop.getTrackAt('A',3);
		Song trackB3 = tapePop.getTrackAt('B',3);
		Song trackLast = tapePop.getTrackAt(tapePop.numTracks());
		Song noSuchTrack = new Song("Beethoven","9th Symphony","60:00");
		assertEquals(tapePop.positionOnSide('A', trackA3), 3);
		assertEquals(tapePop.positionOnSide('B', trackB3), 3);
		assertEquals(tapePop.positionOnTape(trackLast), tapePop.numTracks());
		assertEquals(tapePop.positionOnTape(noSuchTrack), -1);
	}
	
	// uses getTrackAt, numTracks, positionOnSide, positionOnTape
	@Test
	public void testDeleteTrackAt(){
		// test the two-argument form
		Song trackA2 = tapePop.getTrackAt('A',2);  // should be at least 2 on side A
		int lengthA = tapePop.numTracks('A');
		boolean OK = tapePop.deleteTrackAt('A',2);
		assertTrue(OK);
		assertEquals(tapePop.numTracks('A'),lengthA-1);
		assertEquals(tapePop.positionOnSide('A', trackA2),-1);  // assuming no duplicates
		
		// test the one-argument form
		Song trackB2 = tapePop.getTrackAt('B',2);
		int lengthTape = tapePop.numTracks();
		int posB2 = tapePop.numTracks('A')+2; //lengthA-1+2;
		OK = tapePop.deleteTrackAt(posB2);
		assertTrue(OK);
		assertEquals(tapePop.numTracks(),lengthTape-1);
		assertEquals(tapePop.positionOnTape(trackB2),-1);  // assuming no duplicates
		
		// now make it fail
		OK = tapePop.deleteTrackAt('A',99);
		assertFalse(OK);
		assertEquals(tapePop.numTracks(),lengthTape-1);
	}
	
	
	@Test
	public void testFindTracksByArtist()
	{
		// this uses artist names in the default songs array
		Song[] songsEuro = tapePop.findTracksByArtist("Eurogliders");
		assertEquals(songsEuro.length,2);
		assertEquals(songsEuro[0].getArtist(),"Eurogliders");
		assertEquals(songsEuro[1].getArtist(),"Eurogliders");
		Song[] songsINXS = tapePop.findTracksByArtist("INXS");
		assertEquals(songsINXS.length,1);
		Song[] songsChisel = tapePop.findTracksByArtist("Cold Chisel");
		assertTrue(songsChisel==null);
	}
	
	// uses numTracks, getTrackAt, findTracksByArtist, addSongToEnd and insertSongAtPosition
	// assuming tapePop has no duplicates in the first place.
	@Test
	public void testRemoveDuplicates(){
		int numSongsA = tapePop.numTracks('A');
		int numSongsB = tapePop.numTracks('B');
		// add some duplicates to side A
		Song trackA1 = tapePop.getTrackAt('A',1);
		boolean OK = tapePop.addSongToEnd('A',trackA1);
		Song trackA2 = tapePop.getTrackAt('A',2);
		OK = OK && tapePop.insertSongAtPosition('A',3,trackA2);
		// if this fails then maybe the tape was full:
		assertTrue(OK);
		int numSongsA_dup = tapePop.numTracks('A');
		
		// now try the deletion of duplicates:
		tapePop.removeDuplicates('A');
		assertEquals(tapePop.numTracks('A'),numSongsA);
		tapePop.removeDuplicates('B');
		assertEquals(tapePop.numTracks('B'),numSongsB);
		
		// check that we did indeed rid side A of duplicates
		Song[] trax = tapePop.findTracksByArtist(trackA1.getArtist());
		int count = 0;
		for(int ix=0; ix<trax.length; ix++)
			if (trax[ix].equals(trackA1)) count++;
		// there should be exactly one instance of the track
		assertEquals(count,1);
		// could do something similar for trackA2
	}
	

	// uses getTrackAt
	@Test
	//public boolean swapTracks(Song s1, Song s2)
	//public boolean swapTracks(int index1, int index2)
	public void testSwapTracks(){
		Song trackA1 = tapePop.getTrackAt('A',1);
		Song trackB1 = tapePop.getTrackAt('B',1);
		Song trackBend = tapePop.getTrackAt('B',NUMB);
		Song trackAend = tapePop.getTrackAt('A',NUMA);
		Song impostor = new Song("Public Image Ltd","This Is Not A Love Song","4:13");
		//
		// test swapTracks(Song,Song)
		boolean OK = tapePop.swapTracks(trackA1, trackAend);
		assertTrue(OK);
		assertEquals(tapePop.getTrackAt('A',1), trackAend);
		assertEquals(tapePop.getTrackAt('A',NUMA), trackA1);
		
		// test swap with song not in mixtape
		assertFalse(tapePop.swapTracks(trackB1,  impostor));
		
		// test(swapTracks(int,int)
		int ix1 = tapePop.positionOnTape(trackB1);
		int ix2 = tapePop.positionOnTape(trackBend);
		assertTrue((ix1>0)&&(ix2>0));  // just checking...
		tapePop.swapTracks(ix1, ix2);
		assertEquals(tapePop.positionOnTape(trackB1),ix2);
		assertEquals(tapePop.positionOnTape(trackBend),ix1);
	}

}
