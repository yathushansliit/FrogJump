import java.util.Scanner;

public class Frog
{
    int firTime=1,secTime=2,thirTime=5;
    int totalTime=firTime+secTime+thirTime;

    int firDistance=5,secDistance=3,thirDistance=1;
    int totalDistance=firDistance+secDistance+thirDistance;

    int calcDistance(int seconds)
    {
		int count = 0;
        int distance = 0;
        int balance = 0;

        balance=seconds%totalTime;
        count=seconds/totalTime;
        distance=count*totalDistance;

        if (balance!=0 || count==0)
        {
            if (balance<=firTime)
            {
                distance=distance+firDistance;
            }
            else if (balance<=firTime+secTime)
            {
                distance=distance+firDistance+secDistance;
            }
            else if (balance<=totalTime)
            {
                distance = distance + totalDistance;
            }
        }
        return distance;
    }

    int calcTime(int dis)
    {
        int time = 0;
        int count = 0;
        int balance = 0;

        balance=dis%totalDistance;
        count=dis/totalDistance;
        time=count*totalTime;

        if (balance!=0 || count==0 )
        {
            if (balance>firDistance && balance<=firDistance+secDistance)
            {
                time=time+firTime;
            }
            else if (balance>firDistance+secDistance && balance<=totalDistance)
            {
                time = time + totalTime - thirTime;
            }
        }
        return time;
    }

    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.print("Which you want to need to find Distance(d) or Time(t) : ");
        char ch=scan.next().charAt(0);
        Frog f=new Frog();

        if (ch=='d')
        {
            System.out.print("To find Distance, Please enter the Time(Seconds) : ");
            int seconds=scan.nextInt();
            System.out.println("Can jump "+f.calcDistance(seconds)+" meters");
        }
        else
        {
            System.out.print("To find Time, Please enter the Distance(Meters) : ");
            int distance=scan.nextInt();
            System.out.println("It takes "+f.calcTime(distance)+" Seconds");
        }
    }
}