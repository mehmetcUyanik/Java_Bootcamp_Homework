package Homeworks.Homework2.model;

public class Platform {

    private String platformName;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return  platformName ;
    }
}
