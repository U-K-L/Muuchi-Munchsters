/*-----------------------------
 * Contributors: Noah Williams
 * Date Created: 9/24/2017
 * Last Updated 9/26/2017
 * 
 * Purpose: Simple music player.
 -----------------------------*/
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class MusicPlayer {

	public AudioInputStream audio;
	public Clip clip;
	
	//Gets the file for music to be played.
	public void playMusic(String fileName)
	{
		if (fileName != null){
			try{
				File musicFile = new File(fileName);
				audio = AudioSystem.getAudioInputStream(musicFile);
				AudioFormat format = audio.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				clip = (Clip) AudioSystem.getLine(info);
				clip.open(audio);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void stopMusic()
	{
		if(clip != null)
		{
			clip.flush();
			clip.stop();
			clip.close();
		}
	}

}
