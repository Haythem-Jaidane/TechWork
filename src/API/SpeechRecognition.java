/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package API;
/*
import org.mozilla.deepspeech.libdeepspeech.DeepSpeech;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.nio.file.Files;
import java.nio.file.Paths;*/
/**
 *
 * @author Karim
 */
public class SpeechRecognition {/*
   // Create the API client
// Load the credentials from a file
DeepSpeech model = new DeepSpeech("path/to/pretrained/model");

Media media = new Media(new File("path/to/audio/file").toURI().toString());
MediaPlayer mediaPlayer = new MediaPlayer(media);

byte[] audioData = Files.readAllBytes(Paths.get("path/to/audio/file"));
String transcription = model.stt(audioData);


SpeechSettings settings = SpeechSettings.newBuilder().setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();
SpeechClient speechClient = SpeechClient.create(settings);

// Capture user voice input
MediaRecorder recorder = new MediaRecorder();
recorder.setOnReady(() -> recorder.start());
recorder.setOnStopped(() -> {
    byte[] data = recorder.getAudioData();
    ByteString audioBytes = ByteString.copyFrom(data);

    // Send voice input to the API
    RecognitionConfig config = RecognitionConfig.newBuilder().setEncoding(AudioEncoding.LINEAR16).setSampleRateHertz(16000).setLanguageCode("en-US").build();
    RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();
    RecognizeResponse response = speechClient.recognize(config, audio);

    // Display search results
    String transcription = response.getResultsList().get(0).getAlternativesList().get(0).getTranscript();
    // Perform search using the transcription
});

}
*/}