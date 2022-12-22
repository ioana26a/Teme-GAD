package Assignment2_OOP;

public class Iphone12 extends Apple {
        private final String model = "12",imei;
        private final int batteryLife;
        private int leftBattery;
        private String color;
        public Iphone12(String color,String imei,int batteryLife){
                this.color=color;
                this.imei=imei;
                this.batteryLife=batteryLife;
                leftBattery = this.batteryLife;
        }
        @Override
        void sendMessage(String phone, String msg) {
                if (leftBattery == 0) {
                        System.out.println("Low battery.Charge your phone");
                        return;
                }
                super.sendMessage(phone, msg);
                leftBattery--;
        }
        @Override
        void call(String phoneNumber) {
                if(leftBattery<2){
                        System.out.println("Can't make a call.Charge your phone");
                        return;
                }
                super.call(phoneNumber);
                leftBattery-=2;
        }
}
