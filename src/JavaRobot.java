
import static java.lang.Integer.parseInt;


public class JavaRobot 
{

    public static void main(String[] args) 
    {
        int xDir = parseInt(args[0]);
        int yDir = parseInt(args[1]);
        int tem;
        
        String sDir = args[2];
        String sCommand = args[3];
        String[] sClockwise = {"North","East","South","West"};
        String[] sAntiClockwise = {"North","West","South","East"};
        
        char[] cCommands = sCommand.toCharArray();
        
        for(int i=0;i<cCommands.length;i++)
        {
            if(cCommands[i]=='R')
            {
                for(int j=0;j<sClockwise.length;j++)
                {
                    if(j==sClockwise.length-1)
                    {
                        if(sDir.equalsIgnoreCase(sClockwise[j]))
                        {
                            sDir = sClockwise[0];
                            break;
                        }
                    }
                    else
                    {
                        if(sDir.equalsIgnoreCase(sClockwise[j]))
                        {
                            sDir = sClockwise[j+1];
                            break;
                        }
                    }
                }
            }
            if(cCommands[i]=='L')
            {
                for(int j=0;j<sAntiClockwise.length;j++)
                {
                    if(j==sAntiClockwise.length-1)
                    {
                        if(sDir.equalsIgnoreCase(sAntiClockwise[j]))
                        {
                            sDir = sAntiClockwise[0];
                            break;
                        }
                    }
                    else
                    {
                        if(sDir.equalsIgnoreCase(sAntiClockwise[j]))
                        {
                            sDir = sAntiClockwise[j+1];
                            break;
                        }
                    }
                }
            }
            if(cCommands[i]=='W')
            {
                i++;
                tem = Character.getNumericValue(cCommands[i]);
                switch(sDir)
                {
                    case "South" : yDir = yDir - tem;
                                   break;
                    case "North" : yDir = yDir + tem;
                                   break;
                    case "East"  : xDir = xDir + tem;
                                   break;
                    case "West"  : xDir = xDir - tem;
                                   break; 
                }
            }
        }
        System.out.print(xDir + " " + yDir + " " + sDir + "\n");
    }
}
