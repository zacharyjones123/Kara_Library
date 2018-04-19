package Assign1;

import java.util.Arrays;


public class MixTape {
	
	// EDIT THIS TO REFLECT YOUR OWN STUDENT ID PLEASE   *********
	
	static final public int STUDENT_ID = 123456;
	
	
	// INSTANCE VARIABLES:
	/**
	 *  one array for each side of the tape.
	 */
	private Song[] sideA, sideB;
	/**
	 * the length of the tape in minutes;  each side has half this length
	 */
	private int tapeLengthMinutes;
	

	// GET/SET ROUTINES FOR SIDES ARRAYS
    /**
     * Return array of Songs being one of the sides of the tape.  Private for internal use.
     * @param s	which side: 'A' or 'a' for side A;  OR  'B' or 'b' for side B
     * @return Song array 
     */
    private Song[] getSide(char s){
    	if (Character.toLowerCase(s)=='a')
    		return sideA;
    	else if (Character.toLowerCase(s)=='b')
    		return sideB;
    	else return null;
    }
    /**
     * set the designated side of the tape to a specific array of Songs
     * @param s  which side: 'A' or 'a'; OR 'B' or 'b'
     * @param side  array of Songs to set to designated side.
     * @return true on success.  False when s has a bad value.
     */
    private boolean setSide(char s, Song[] side){
    	if (Character.toLowerCase(s)=='a'){
    		sideA = side;
    		return true;
    	} else if (Character.toLowerCase(s)=='b'){
    		sideB = side;
    		return true;
    	} else return false;
    }

    /**
     * set each of two sides to an empty array
     */
    private void initialiseSides(){
		sideA = new Song[0];
		sideB = new Song[0];
	}
	
	
	//  /  /  /  /  /  /  /  /  /  /  /  /  /  /  /  /  /  /  /  /  /  /
    // CONSTRUCTORS
	
	/**
	 * Construct a MixTape with empty data (no songs).
	 * @param minutes  maximum length of tape; each side has half this length.
	 */
	public MixTape(int minutes) {
		tapeLengthMinutes = minutes;
		initialiseSides();
	}

	/**
	 * Construct a MixTape and populate it with data from songarray
	 * This is to be used only by testing routines, to easily set up a MixTape without
	 * recourse to other member functions.
	 * 
	 * @param minutes
	 * @param songarray
	 * @param ntake
	 * @throws Exception 
	 */
	public MixTape(int minutes, Song[] songarray, int ntake1, int ntake2) throws Exception{
		tapeLengthMinutes = minutes;
		sideA = new Song[ntake1];
		sideB = new Song[ntake2];
		if (songarray.length<(ntake1+ntake2))
			throw new Exception("supplied song array was too short");
		int index = 0;
		for(int i=0; i<ntake1; i++) sideA[i] = songarray[index++];
		for(int j=0; j<ntake2; j++) sideB[j] = songarray[index++];
	}
	
	//  /  /  /  / /   /  /  /  /  /  /  / /  /  /  /  /  /  /  /  /  /  / 
	// OUTPUT
	
	/**
	 * Dump info to screen without recourse to other method functions.
	 * YOU CAN USE THIS TO PRINT TAPE INFO TO SCREEN BEFORE OTHER METHODS ARE WRITTEN.
	 * Use it for debugging, testing, etc.
	 */
	public void dump(){
		System.out.println("This tape has length " + tapeLengthMinutes);
		Song[] side = sideA;
		for(int i=1;i<=2;i++){
			System.out.println("side " + ((i==1)?'A':'B'));
			if ((side==null)||(side.length==0)) System.out.println("\tno tracks.");
			else{
				for(int k=0; k<side.length; k++)
					System.out.printf("    %2d | %s\n",k+1,side[k]);
			}
			side=sideB;
		}
	}
	
	
	/*
	 * YOU WILL NOT BE ABLE TO USE THIS UNTIL CERTAIN METHODS HAVE BEEN WRITTEN.
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String str = "";
		str += "Tape total length is " + tapeLengthMinutes + " minutes.\n";
		char[] sides = {'A','B'};
		for(char s: sides){
			str += String.format("\tSide %c: \n", s);
			if (numTracks(s)==0) str += "\t\tEMPTY.\n";
			for(int i=0; i<numTracks(s); i++){
				str += String.format("  %2i ",i+1);
				str += getTrackAt(s,i+1) + "\n";
			}
			if (sideIsFull(s)){
				str += "\tFULL.\n";
			}else{
				int mleft = timeLeftSeconds(s)/60;
				int sleft = timeLeftSeconds(s)-60*mleft;
				str += String.format("\tTime remaining: %i:%2i \n",mleft,sleft);
			}
		}	
		return str;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	// EMPTY MEMBERS START HERE - Your job is to supply the method bodies for each one.
	// Discard any return statements - they are only supplied so this class will compile as-is.
	// You will write your own return statements.
	
	
	/**
	 * Replace the Song array of specified side with an array having the same Songs but no nulls.
	 * Example:  if side A has 6 elements, {A, null, B, C, null, D}
	 *           then calling compactSide('A') replaces the array with one having the 4 elements
	 *           {A, B, C, D}
	 * *** CODE THIS METHOD AND USE IT IN YOUR OTHER METHODS *****
	 * @param s  which side:  'A' or 'a',  'B' or 'b'.  If none of these, no action is performed.
	 */
	private void compactSide(char s){
		//Array we are working with 
		Song[] songs = null;
		//Figure out when array we are working with
		if(s == 'A') {
			//Working with side A
			songs = sideA;
		} else {
			//Working with side B
			songs = sideB;
		}
		//Need to find the number of non-null elements first
		int counter = 0;
		for(int i = 0; i < songs.length; i++) {
			if(songs[i] != null) {
				counter++;
			}
		}
		//Now, make a new array that has all the non-zero elements
		//And Fill it
		Song[] newSongs = new Song[counter];
		int j = 0;
		for(int i = 0; i < songs.length; i++) {
			if(songs[i] != null) {
				newSongs[j] = songs[i];
				j++;
			}
		}
		
		//Now, say that the new side is done
		if(s == 'A') {
			//Working with side A
			sideA = newSongs;
			for(int i = 0; i < sideA.length; i++) {
				//System.out.println(sideA[i]);
			}
		} else {
			//Working with side B
			sideB = newSongs;
			for(int i = 0; i < sideB.length; i++) {
				//System.out.println(sideB[i]);
			}
		}
		
		
		
	}
	
	/**
	 * replace the Song array of specified side with an array of one more element,
	 * having the same data as the original array, but with the final extra element being null.
	 * Example:  if side A is {A, B, C, D}
	 * 		     then growSide('A') turns it into {A, B, C, D, null}
	 * 			 and the instance variable sideA henceforth refers to this new array.
	 * @param s  which side:  'A' or 'a';  'B' or 'b'.  Any other value causes no action.
	 * @return  the newly-grown array.
	 */
	private Song[] growSide(char s){
		
		//Array we are working with 
				Song[] songs = null;
				//Figure out when array we are working with
				if(s == 'A') {
					//Working with side A
					songs = new Song[sideA.length + 1];
					//Now fill the array
					for(int i = 0; i < sideA.length; i++) {
						songs[i] = sideA[i];
					}
				} else {
					//Working with side B
					songs = new Song[sideA.length + 1];
					//Now fill the array
					for(int i = 0; i < sideB.length; i++) {
						songs[i] = sideB[i];
					}
				}
		return songs;
	}
	
	
	// HINT: use the above methods liberally in your other methods!
	
	
	/**
	 * get the Song at specified position on given side, or return null if there is no such track.
	 * @param whichSide  'A','a','B','b'
	 * @param position	index of song, from 1 to number of tracks on the side.
	 * @return requested Song, or null
	 */
	public Song getTrackAt(char whichSide, int position){
		compactSide(whichSide);
		if(whichSide == 'A') {
			//System.out.println(sideA[position-1]);
			return sideA[position-1];
		} else {
			System.out.println(sideB[position-1]);
			return sideB[position-1];
		}
	}
	
	/**
	 * get the Song at specified position on the tape, or return null if there is no such track.
	 * this is the same as getTrackAt(char whichSide, int position) except here the position refers
	 * to the position on the entire tape, counting tracks on side A first, then on side B.
	 * @param position  index of track, between 1 and the sum of lengths of both sides.
	 * @return requested Song, or null 
	 */
	public Song getTrackAt(int position){
		if(position < sideA.length) {
			//System.out.println(sideA[position-1]);
			return sideA[position-1];
		} else if(position < sideA.length + sideB.length) {
			return sideB[position - sideA.length-1];
		} else {
			return null;
		}
	}
	
	/**
	 * set the given track on given side of the tape to the supplied Song.
	 * This replaces any existing Song in that position;  if there is no such position/side 
	 * then false is returned.
	 * @param whichSide  'A','a','B','b'
	 * @param position  index on 1 to the length of specified side
	 * @param sing the Song to set at this position
	 * @return  true on success, false otherwise
	 */
	public boolean setTrackAt(char whichSide, int position, Song sing){
		
		compactSide(whichSide);
		if(whichSide == 'A') {
			if(position >= sideA.length) {
				return false;
			} else {
				sideA[position - 1] = sing;
				return true;
			}
		} else {
			if(position >= sideB.length) {
				return false;
			} else {
				sideB[position - 1] = sing;
				return true;
			}
		}
	}
	
	/**
	 * set the given track at given position on the tape to the supplied Song.
	 * This replaces any existing Song in that position;  if there is no such position/side 
	 * then false is returned.
	 * This is the same as setTrackAt(char whichSide, int position, Song sing)
	 * except that the position refers to the position on the entire tape, counting from the
	 * start of side A, and then side B.
	 * @param position  index on 1 to the sum of lengths of both sides
	 * @param sing the Song to set at this position
	 * @return  true on success, false otherwise
	 */
	public boolean setTrackAt(int position, Song sing){
		
		if(position < sideA.length) {
			//System.out.println(sideA[position-1]);
			sideA[position-1] = sing;
			return true;
		} else if(position <= sideA.length + sideB.length) {
			sideB[position - sideA.length - 1] = sing;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Return the number of tracks on designated side of the MixTape
	 * @param s  which side
	 * @return  number of tracks on that side
	 */
	public int numTracks(char s){   
		
		compactSide(s);
		if(s == 'A') {
			return sideA.length;
		} else {
			return sideB.length;
		}
	}
	
	/**
	 * count number of tracks on both sides of the tape
	 * @return  number of tracks on the tape
	 */
	public int numTracks(){
		return sideA.length + sideB.length; 
	}

	/**
	 * Add Song to specified position on given side of the MixTape.
	 * The side array must be grown to incorporate the new Song.
	 * Example:  if sideA is {A, B, C, D} 
	 * 	         then insertSongAtPosition('A',2,X) replaces side A with {A, B, X, C, D}
	 * If the side is already over its maximum duration then the new song must not be inserted
	 * Otherwise the song is inserted, even if this would push the duration over the limit.
	 * @param whichSide  'a','A','B','b'
	 * @param pos	index on 1 to length+1 of specified side
	 * @param ess 	the SOng to add
	 * @return true on success, false if 
	 */
	public boolean insertSongAtPosition(char whichSide, int pos, Song ess){
		return false;
	}
	
	/**
	 * remove track at given side/position
	 * Example: if side A is {A, B, C, D} 
	 * 			then deleteTrackAt('A',3) changes sideA to {A, B, D}
	 * @param whichSide 'A','a','B','b'
	 * @param pos  index of track on selected side, from 1 to length
	 * @return true on success, false if no such side/position
	 */
	public boolean deleteTrackAt(char whichSide, int pos){
		return false;
	}
	
	/** 
	 * remove track at given position.
	 * Same as deleteTrackAt(char whichSide, int pos) but position here is position on whole tape,
	 * counting tracks on sideA and then sideB.
	 * @param position
	 * @return true on success, false if no such position.
	 */
	public boolean deleteTrackAt(int position){
		return false;
	}

	/**
	 * determine position on given side of specified Song
	 * @param whichSide  'A','a','B','b'
	 * @param tune	the Song to find
	 * @return index on 1..length of Song on give side, or false if Song not on that side.
	 */
	public int positionOnSide(char whichSide, Song tune){
		return -1;
	}
	
	/**
	 * determine position on entire tape of specified Song
	 * @param tune  the Song
	 * @return  index on 1 .. sum of lengths
	 */
	public int positionOnTape(Song tune){
		return -1;
	}
	
	/**
	 * Fing all Songs by a given artist on entire MixTape
	 * @param artist  Name of artist to search for
	 * @return  array of Songs having specified artist.
	 */
	public Song[] findTracksByArtist(String artist){
		return null;
	}
	
	/**
	 * remove any duplicate tracks from a side of the MixTape
	 * Example:  if side A is {A, B, A, C, D, E, C}
	 * 			then removeDuplicates('A') sets sideA to {A, B, C, D, E}
	 * @param whichSide  'A','a','B','b'
	 */
	public void removeDuplicates(char whichSide){
		
	}
	
	/**
	 * total amount of time taken by tracks on given side
	 * @param whichSide
	 * @return occupied time in minutes.  Half a minute = 0.5
	 */
	public double timeOccupiedMinutes(char whichSide){
		return -1.0;
	}
	
	/**
	 * total amount of time taken by tracks on given side
	 * @param whichSide
	 * @return  occupied time in seconds.
	 */
	public int timeOccupiedSeconds(char whichSide){
		return -1;
	}
	
	/**
	 * time left on given side
	 * @param whichSide
	 * @return remaining time in seconds
	 */
	public int timeLeftSeconds(char whichSide){
		return -1;
	}
	
	/** 
	 * time left on given side
	 * @param whichSide
	 * @return remaining time in minutes
	 */
	public double timeLeftMinutes(char whichSide){
		return -1.0;
	}
	
	/**
	 * determine if side is full:  total time is equal to or exceeds that side's time length
	 * maximum time of a side is half of the MixTape's total time.
	 * @param whichSide
	 * @return true if total time of tracks exceeds/equals runtime, false otherwise
	 */
	public boolean sideIsFull(char whichSide){
		return false;
	}
	
	/**
	 * determine if whole tape is full:  Each side of tape is full.
	 * @return true if both sides are full
	 */
	public boolean tapeIsFull(){
		return false;
	}
	
	/**
	 * add the given song to the end of the specified side of the tape.
	 * If that side of the tape has already exceeded its maximum duration
	 * then the new song is not added and false is returned.
	 * Otherwise, even if that song would cause the maximum length to be exceeded,
	 * the song is added to end and true is returned,
	 * @param whichSide  'A','a','B','b'
	 * @param ess  the Song to add
	 * @return  true if Song is successfully added, false if not.
	 */
	public boolean addSongToEnd(char whichSide, Song ess){
		return false;
	}
	
	/**
	 * Add given Song to end of tape
	 * First attempts to add to side A, but if this is already full then attempt to add to side B.
	 * @param ess  the Song to add
	 * @return true on success
	 */
	public boolean addSongToEnd(Song ess){
		return false;
	}
	
	/**
	 * *** THIS ONE IS FOR ADVANCED STUDENTS ***
	 * Order songs on each side of MixTape in alphabetical order of artist name, 
	 * and then by song title.  Each side is ordered independently of the other.
	 * *** WRITE YOUR OWN SORT ROUTINE.  DON'T USE Arrays.sort .
	 */
	public void sortSides(){
	}
	
	/**
	 * Given two songs, if both songs exist anywhere on the entire MixTape then swap their positions.
	 * @param s1  first Song
	 * @param s2  second Song
	 * @return  true if tracks are successfully swapped.  False otherwise, eg if one/both songs are not on tape.
	 */
	public boolean swapTracks(Song s1, Song s2){
		return false;
	}
	
	/**
	 * Swap positions of two songs of specified position.
	 * Positions are measured as position on entire tape, counting from side A, then side B.
	 * @param index1  position of first song
	 * @param index2  position of second song
	 * @return  true on success, false otherwise (one/both positions do not exist)
	 */
	public boolean swapTracks(int index1, int index2){
		return false;
	}
	
	/**
	 * *** THIS ONE IS FOR ADVANCED STUDENTS ***
	 * If the time Occupied on each side is less than the length of each side
	 * (i.e. neither side is full) then return true.
	 * If one side is full, but both sides can be made not-full by swapping tracks between
	 * the sides, then do the swap and return true.
	 * If one or two sides are full, and swapping tracks cannot make both sides not-full,
	 * then return false.
	 * @return true on successful balance, false if balance could not be achieved.
	 */
	public boolean balanceSides(){
		return false;
	}
	
	////////////////////////////////////////////////
	
	public static void main(String[] args) {
		// This is a test driver.  Feel free to use this for testing.
		// Better still, delete the guts of this routine and replace it with code
		// to do your own personal testing.
		
		MixTape mt = new MixTape(90);
		Song[] library = Song.testArray();
		
		mt.addSongToEnd('A', library[0]);
		mt.addSongToEnd('A', library[8]);
		mt.addSongToEnd('B', library[2]);
		mt.addSongToEnd('B', library[3]);
		mt.insertSongAtPosition('A',  2, library[4]);
		//
		mt.addSongToEnd('A', library[0]);  // a duplicate
		mt.addSongToEnd('A',  library[5]);
		mt.addSongToEnd('B', library[6]);
		mt.addSongToEnd('B', library[7]);
		mt.addSongToEnd('B', library[1]);
		
		mt.dump();
		System.exit(0);
		
		System.out.println("= = = = = = = = =");
		
		System.out.println("Track A 3: " + mt.getTrackAt('A',3));
		System.out.println("Track 9: " + mt.getTrackAt(9));
		System.out.println("numtracks A " + mt.numTracks('A') + ", B " + mt.numTracks('B')
			+ ", tot " + mt.numTracks() );
		
		mt.deleteTrackAt(9);
		mt.deleteTrackAt('A',3);
		mt.dump();
		
		System.out.println("- = - = - = - = -");
		
		System.out.println("(first) pos of lib 0 on side A: " + mt.positionOnSide('a',library[0]));
		System.out.println("(first) pos of lib 0 on side B: " + mt.positionOnSide('b',library[0]));
		System.out.println("(first) overall pos of lib 0: " + mt.positionOnTape(library[0]));
		
		System.out.println("tracks by GANGgajang: ");
		Song[] foo = mt.findTracksByArtist("GANGgajang");
		for(int i=0; i<foo.length; i++) System.out.println(foo[i]);
		
		mt.removeDuplicates('a');
		mt.dump();
	}

}
