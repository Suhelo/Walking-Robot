
import static java.lang.Integer.parseInt;


public class JavaRobot 
{

    public static void main(String[] args) 
    {
        if(args.length==0)
        {
            System.out.println("Please give 4 inputs for X-input, Y-input, Direction and Command");
            System.exit(0);
        }
        int xDir = parseInt(args[0]);
        int yDir = parseInt(args[1]);
        int tem;
        int flag=0;
        
        String sDir = args[2];
        String sCommand = args[3];
        String[] sClockwise = {"North","East","South","West"};
        String[] sAntiClockwise = {"North","West","South","East"};
        String sSteps = "";
        
        char[] cCommands = sCommand.toCharArray();
        
        for(int i=0;i<cCommands.length;i++)
        {
            if(cCommands[i]=='R' || cCommands[i]=='r')
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
                flag=1;
            }
            if(cCommands[i]=='L' || cCommands[i]=='l')
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
                flag=1;
            }
            if(cCommands[i]=='W' || cCommands[i]=='w')
            {
                try
                {
                    i++;
                    sSteps = sSteps+cCommands[i];
                    while(i<cCommands.length-1 && (Character.isDigit(cCommands[i+1])))
                    {
                        sSteps = sSteps+cCommands[i+1];
                        i++;
                    }                                              
                    tem = parseInt(sSteps);
                    switch(sDir.toUpperCase())
                    {
                        case "SOUTH" : yDir = yDir - tem;
                                       flag=1; 
                                       break;
                        case "NORTH" : yDir = yDir + tem;
                                       flag=1; 
                                       break;
                        case "EAST"  : xDir = xDir + tem;
                                       flag=1; 
                                       break;
                        case "WEST"  : xDir = xDir - tem;
                                       flag=1; 
                                       break; 
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    System.out.println("Not a valid input. Please give proper arguments");
                }
                
            }
            if(flag==0)
            {
                System.out.println("Not a valid input. Please give proper arguments");
                System.exit(0);
            }
        }
        System.out.print(xDir + " " + yDir + " " + sDir + "\n");
    }
}
