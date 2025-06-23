//firebase->FirebaseLeaderboard

package firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import models.Task;
import models.User;

public class FirebaseLeaderboard {

    public static void uploadUserStats(User user) {
        int completed = (int) user.getTasks().stream().filter(Task::isCompleted).count();

        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference("leaderboard")
                .child(user.getUsername()); // Use username as key

        ref.child("level").setValueAsync(user.getLevel());
        ref.child("xp").setValueAsync(user.getXp());
        ref.child("completedTasks").setValueAsync(completed);
    }
}