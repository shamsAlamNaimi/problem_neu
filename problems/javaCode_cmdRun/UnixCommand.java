import java.util.Stack;

public class UnixCommand {


    public String executeCommand(String currLocation,String command){
        Stack<String> location= new Stack<String>();

        for(int i=0;i<currLocation.length();i++){
            StringBuilder sb= new StringBuilder();
            while(i<currLocation.length()&&currLocation.charAt(i)=='/') i++;
            while(i<currLocation.length()&&currLocation.charAt(i)!='/'){
                sb.append(currLocation.charAt(i));
                i++;
            }
            if(sb.length()!=0) location.push(sb.toString());
        }
        int j=0;
        while(command.charAt(j)==' ') j++;
        if(command.charAt(j)=='/') location.clear();

        for(int i=0;i<command.length();i++){
            StringBuilder sb= new StringBuilder();
            while(i<command.length()&&command.charAt(i)=='/') i++;
           
            while(i<command.length()&&command.charAt(i)!='/'){
                sb.append(command.charAt(i));
                i++;
            }
            
            if(sb.toString().equals("..")){
                if(!location.isEmpty()) location.pop();
            }
            else if(sb.toString().equals(".") || sb.toString().equals(" ")) continue;
            else if(!sb.toString().matches("^[a-zA-Z0-9 ]*$")) return new String(command+": No such file or directory");
            else if(sb.length()!=0) location.push(sb.toString());
        }


        Stack<String> stack =new Stack<String>();
        while(!location.isEmpty()) stack.push(location.pop());


        StringBuilder res= new StringBuilder();
        while(!stack.isEmpty()){
            res.append('/');
            res.append(stack.pop());
        }

        return (res.length()==0)?"/":res.toString();
    }


    public static void main(String[] args) {
        UnixCommand un= new UnixCommand();
        String s2="/a/b/..... ";
        String s1="/abc/def";
        System.out.println("Current Locations:::::: "+un.executeCommand(s1, s2));
    }

}
