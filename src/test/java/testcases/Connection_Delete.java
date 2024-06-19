package testcases;

import com.jcraft.jsch.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Connection_Delete {

    public static void main(String[] args) {
        String host = "lhr-190.snlhrprshared1.gbucdsint02lhr.oraclevcn.com";
        String user = "digistdevops";
        String password = "C1g2b3u4#";

        try {
            JSch jsch = new JSch();
            // Connect to the remote server
            Session session = jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            // Execute a command (e.g., print the current working directory)

            Channel channel = session.openChannel("exec");
            InputStream in = channel.getInputStream();
            ((ChannelExec) channel).setCommand("cd /home/digistdevops/ST_QA_Seagull/seagull/diameter/scenario && ls -ltr && ./run.sh data_21SEP_SH.xml");
            channel.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
            synchronized (channel) {
                channel.wait(10000);
            }
            channel.disconnect();
            session.disconnect();
        }
        catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
