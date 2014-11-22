package percolatechallenge.eileenyau.coffee.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;

public class ContactUtil {

    public static void sendEmail(Context context, String email) throws Exception {
        sendEmail(context, email, null);
    }

    public static void sendEmail(Context context, String email, String subject) {
        sendEmail(context, email, null, null);
    }

    public static void sendEmail(Context context, String email, String subject, String body) throws ActivityNotFoundException{
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        context.startActivity(intent);
    }
}
