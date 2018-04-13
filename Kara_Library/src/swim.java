import java.util.ArrayList;

public class swim
{

	private char team;
	private String name;
	private int weight;
	private char gender;
	private int age;
	private String group;
	private double front;
	private double back;
	private double freestyle;
	private double butterfly;
	private char choice;

	public swim(char teamGiven, String nameGiven, int weightGiven, char genderGiven, int ageGiven, String groupGiven, double frontGiven, double backGiven, double butterflyGiven, char choiceGiven)
	{
		if(teamGiven!='V'&&teamGiven!='J')
		{
			System.out.print("Error!");
		}
		else
		{
			team=teamGiven;
		}
		name=nameGiven;
		if(weightGiven<1)
		{
			System.out.print("ERROR!");
		}
		else
		{
			weight=weightGiven;
		}
		if(genderGiven!='M'&&genderGiven!='F')
		{
			System.out.print("Error!");
		}
		else
		{
			gender=genderGiven;
		}
		if(ageGiven<6|ageGiven>18)
		{
			System.out.print("Error");
		}
		else
		{
			age=ageGiven;
		}
		group=groupGiven;
		if(frontGiven<1.0)
		{
			System.out.print("Error!");
		}
		else
		{
			front=frontGiven;
		}
		if(backGiven<1.0)
		{
			System.out.print("Error!");
		}
		else
		{
			back=backGiven;
		}
		if(butterflyGiven<1.0)
		{
			System.out.println("Error!");
		}
		else
		{
			butterfly=butterflyGiven;
		}
		if(choiceGiven!='Y'&& choiceGiven!='N')
		{
			System.out.print("Error!");
		}
		else
		{
			choice=choiceGiven;
		}
	}

	public swim()
	{
		team='\0';
		name="";
		weight=0;
		gender='\0';
		age=0;
		group="";
		front=0.0;
		back=0.0;
		freestyle=0.0;
		butterfly=0.0;
		choice='\0';
	}

	public void setTeam(char teamGiven)
	{
		team=teamGiven;
	}

	public void setName(String nameGiven)
	{
		name=nameGiven;
	}

	public void setAge(int ageGiven)
	{
		age=ageGiven;
	}

	public void setGender(char genderGiven)
	{
		gender=genderGiven;
	}

	public void setWeight(int weightGiven)
	{
		weight=weightGiven;
	}

	public void setGroup(String groupGiven)
	{
		group=groupGiven;
	}

	public void setFront(double frontGiven)
	{
		front=frontGiven;
	}

	public void setBack(double backGiven)
	{
		back=backGiven;
	}

	public void setFreestyle(double freestyleGiven)
	{
		freestyle=freestyleGiven;
	}

	public void setButterfly(double butterflyGiven)
	{
		butterfly=butterflyGiven;
	}

	public void setChoice(char choiceGiven)
	{
		choice=choiceGiven;
	}

	public char getTeam()
	{
		return team;
	}

	public String getName()
	{
		return name;
	}

	public int getWeight()
	{
		return weight;
	}

	public char getGender()
	{
		return gender;
	}

	public int getAge()
	{
		return age;
	}

	public String getGroup()
	{
		return group;
	}

	public double getFront()
	{
		return front;
	}

	public double getBack()
	{
		return back;
	}


	public double getButterfly()
	{
		return butterfly;
	}

	public double getTotalTime()
	{
		double totalTime=0.0;

		totalTime=back+front+butterfly;

		return totalTime;
	}

	public char getChoice()
	{
		return choice;
	}

	public String getStatus()
	{

		String status="";

		if(team=='v' && age>14 && front>=100 && back>=100  && butterfly>=60)
		{
			status="untitled";
		}

		else if(team=='v' && age>14 && front>=80 && back>=80 && butterfly>=30)
		{
			status="bronze";
		}

		else if(team=='v' && age>14 && front>=60 && back>=60 && butterfly>=25)
		{
			status="silver";
		}

		else if(team=='v' && age>14 && front>=80 && back>=100 && butterfly>=20)
		{
			status="gold";
		}

		else if(team=='j'&& age<=14 && front>=120 && back>=120 && butterfly>=80)
		{
			status="untitled";
		}

		else if(team=='j'&& age<=14 && front>=100 && back<=90 && butterfly>=60)
		{
			status="bronze";
		}

		else if(team=='j' && age<=14 && front>=70 && back>=70 && butterfly>=45)
		{
			status="silver";
		}

		else if(team=='j'  && age<=14 && front>=50 && back>=50 && butterfly>=35)
		{
			status="gold";
		}

		else 
		{
			status="unknown";
		}

		return status;

	}


}

