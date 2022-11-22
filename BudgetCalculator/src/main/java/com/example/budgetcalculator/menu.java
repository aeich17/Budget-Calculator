public class menu {
    public double userRevenue;
    public double userTaxRate;

    public menu(double userRevenue, double userTaxRate) {
        this.userTaxRate = userTaxRate;
        this.userRevenue = userRevenue;
    }

    public void setUserRevenue() {
        userRevenue = this.userRevenue;
    }
    public double getUserRevenue() {
        return userRevenue;
    }
    public void setUserTaxRate() {
        userTaxRate = this.userTaxRate;
    }
    public double getUserTaxRate() {
        return userTaxRate;
    }
}
