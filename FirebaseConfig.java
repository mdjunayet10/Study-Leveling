//firebase->FirebaseConfig
package firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.InputStream;

public class FirebaseConfig {
    public static void initialize() {
        try {
            // Load the service account from resources using classloader
            InputStream serviceAccount = FirebaseConfig.class.getClassLoader()
                    .getResourceAsStream("serviceAccountKey.json");

            if (serviceAccount == null) {
                System.err.println("❌ serviceAccountKey.json not found in resources.");
                return;
            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://study-leveling-default-rtdb.asia-southeast1.firebasedatabase.app/")  // replace with your DB URL
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("✅ Firebase initialized successfully.");
        } catch (Exception e) {
            System.err.println("❌ Failed to initialize Firebase.");
            e.printStackTrace();
        }
    }
}