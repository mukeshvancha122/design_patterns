package structural;

// Payment processor interface
interface PaymentProcessor{
    void processPayment(double amount);
}

// payment via paypal
class PaypalProcessor implements PaymentProcessor{
    public void processPayment(double amount){
        System.out.println("Payment of amount $"+amount);
    }
}

// third party payment
class StripeSDK {
    public void makePayment(int cents){
        System.out.println("Processing payment of $"+cents+" via Stripe SDK");
    }
}

class StripeAdaptor implements PaymentProcessor{
    private StripeSDK stripeSDK;

    public StripeAdaptor(StripeSDK stripeSDK){
        this.stripeSDK = stripeSDK;
    }

    public void processPayment(double amount){
        int cents = (int)(amount * 100);
        stripeSDK.makePayment(cents);
    }
}

class AdaptorEcommerce {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PaypalProcessor();
        paypal.processPayment(50.0);

        PaymentProcessor stripe = new StripeAdaptor(new StripeSDK());
        stripe.processPayment(75.5);
    }
}

