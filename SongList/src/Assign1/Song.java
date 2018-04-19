package Assign1;


public final class Song implements Comparable<Song>{


	/**
	 * the title of this song, e.g. "99 Luftballoons"
	 */
	private String title;
	/**
	 * the name of this Song's artist, e.g. "Nena"
	 */
	private String artist;
	/**
	 * The duration of this song.  e.g. "99 Luftballoons" has duration
	 * of 3 minutes and 54 seconds.
	 */
	private int minutes, seconds;
	
	/**
	 * Construct song, specifying duration wholly in seconds
	 * e.g. durationSecs==210 implies minutes==3 and seconds==30
	 * @param art  artist name
	 * @param tit  song title
	 * @param durationSecs  total length of song in seconds
	 */
	public Song(String art,String tit, int durationSecs){
		this(art,tit, durationSecs/60, durationSecs%60);
	}
	/**
	 * Construct song, specifying duration in minutes.
	 * e.g. durationMins==3.5 implies minutes==3 and seconds==30
	 * @param art  artist name
	 * @param tit  song title
	 * @param durationMins  total length of song in MINUTES.
	 */
	public Song(String art,String tit, double durationMins){
		this(art,tit,(int)durationMins,(int)(60*(durationMins-(int)durationMins)));
	}
	/**
	 * Song constructor, specifying duration as minutes & seconds
	 * @param art  artist name
	 * @param tit  Song title
	 * @param mins  minutes component of duration
	 * @param secs  seconds component of duration
	 */
	public Song(String art, String tit, int mins, int secs){
		//this(tit,art,(double)secs/60+mins);
		title = tit;
		artist = art;
		minutes = mins;
		seconds = secs;
	}
	/**
	 * Song constructor, specifying duration as String
	 * Format of String must be "X:Y"
	 * where X is minutes and Y is seconds
	 * @param art  artist name
	 * @param tit  Song title
	 * @param duration  length of song as String "X:Y"
	 */
	public Song(String art, String tit, String duration){
		this(art,tit,0,0);
		String[] parts = duration.split(":");
		minutes = Integer.parseInt(parts[0]);
		seconds = Integer.parseInt(parts[1]);
	}

	/**
	 * @return  minutes part of duration
	 */
	public int getMinutes(){
		return minutes;
	}
	/**
	 * @return  seconds part of duration
	 */
	public int getSeconds(){
		return seconds;
	}
	/**
	 * @return  Song title
	 */
	public String getTitle(){
		return title;  
	}
	/**
	 * @return  artist name
	 */
	public String getArtist(){
		return artist;
	}
	
	/**
	 * @return  total duration as minutes
	 */
	public double durationMinutes(){
		return (double)minutes + (double)seconds/60;
	}
	/**
	 * @return  total duration as seconds
	 */
	public int durationSeconds(){
		return minutes*60+seconds;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String secStr = Integer.toString(getSeconds());
		if (secStr.length()<2)
			secStr = "0"+secStr;
		//return artist + ", " + title + " (" + minutes + ":" + secStr + ")";
		return String.format("%20s",artist)+ ", " + String.format("%30s", title) + " (" + minutes + ":" + secStr + ")";
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other){
		if (other==null) return false;
		if (other.getClass()!=this.getClass()) return false;
		Song asSong = (Song)other;
		return (asSong.getTitle()==this.getTitle())&&(asSong.getArtist()==this.getArtist());
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Song other){
		int cmpArtist = this.artist.compareTo(other.artist);
		if (cmpArtist==0)
			return this.title.compareTo(other.title);
		else
			return cmpArtist;				
	}
	/////////////////////////////////////////
	
	/**
	 * @return an array of daggy 1980s Songs for testing MixTape members
	 */
	public static Song[] testArray(){
		Song[] tracks = new Song[99];
		int ix=0;
		tracks[ix++] = new Song("Machinations","My Heart's On Fire", "5:00");
		tracks[ix++] = new Song("Machinations","No Say In It","3:21");
		tracks[ix++] = new Song("INXS","This Time","3:10");
		tracks[ix++] = new Song("GANGgajang","Sounds Of Then","3:53");
		tracks[ix++] = new Song("Dragon","Dreams Of Ordinary Men","4:01");
		tracks[ix++] = new Song("Dragon","Young Years","3:58");
		tracks[ix++] = new Song("Uncanny X-Men","50 Years","4:03");
		tracks[ix++] = new Song("Eurogliders","Heaven","3:42");
		tracks[ix++] = new Song("Eurogliders","We Will Together","4:33");
		tracks[ix++] = new Song("Split Enz","I Walk Away","3:47");
		tracks[ix++] = new Song("GANGgajang","Giver Of Life","3:41");
		tracks[ix++] = new Song("GANGgajang","Gimme Some Loving","2:37");
		tracks[ix++] = new Song("The Church","Under The Milky Way","4:59");
		tracks[ix++] = new Song("Do Re Mi", "Man Overboard","4:12");
		tracks[ix++] = new Song("Icehouse","Don't Believe Anymore","5:08");
		tracks[ix++] = new Song("FAB","Happy People","3:52");
		tracks[ix++] = new Song("Flowers","We Can Get Together","3:48");
		tracks[ix++] = new Song("The Globos","The Beat Goes On","3:34");
		tracks[ix++] = new Song("Goanna","Solid Rock","4:32");
		tracks[ix++] = new Song("Icehouse","Great Southern Land","5:09");
		tracks[ix++] = new Song("Hoodoo Gurus","Bittersweet","3:40");
		tracks[ix++] = new Song("Jo Jo Zep","Taxi Mary","3:47");
		tracks[ix++] = new Song("Little River Band","Down On The Border","2:51");
		tracks[ix++] = new Song("Icehouse","Love In Motion","3:41");
		tracks[ix++] = new Song("Men At Work","Down Under","3:39");
		tracks[ix++] = new Song("Mental As Anything","He's Just No Good For You","3:10");
		tracks[ix++] = new Song("Models","Big On Love","3:54");
		tracks[ix++] = new Song("Models","Hold On","4:13");
		tracks[ix++] = new Song("Models","I Hear Motion","5:22");
		tracks[ix++] = new Song("Mondo Rock","Summer Of '81","3:55");
		tracks[ix++] = new Song("Mondo Rock","Come Said The Boy","5:33");
		tracks[ix++] = new Song("Mondo Rock","Cool World","3:34");
		
		
		//System.out.println("array has " + ix + " tracks.");
		Song[] temp = tracks;
		tracks = new Song[ix];
		System.arraycopy(temp, 0, tracks, 0, ix);
		
		return tracks;
	}

	////////////////////////////////////////////////////////
	
	/**
	 * test driver
	 * @param args
	 */
	public static void main(String[] args){
		
		Song[] tracks = testArray();
		
		for(int q=0; q<tracks.length; q++)
			System.out.printf("%2d| %s\n",q,tracks[q].toString());
	}

}
