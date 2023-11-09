import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

// this is an example Kelly created to test the Email API. see whether Email APi can send enail to our user

public class Example {
    // using SendGrid's Java Library
// https://github.com/sendgrid/sendgrid-java



    public static void main(String[] args) throws IOException {
        Email from = new Email("qiuwenyu60@gmail.com");
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email("qiuwenyu2021@outlook.com");
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;

        }
    }
}
