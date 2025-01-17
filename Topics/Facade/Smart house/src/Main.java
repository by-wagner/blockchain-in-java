class SmartHouseFacadeTestDrive {
    public static void main(String[] args) {
        StereoSystem stereoSystem = new StereoSystem();
        Bathroom bathroom = new Bathroom();
        Lights lights = new Lights();

        SmartHouseFacade smartHouseFacade = new SmartHouseFacade(stereoSystem, bathroom, lights);

        lights.setFavoriteColorTemperature("Calming blue");
        stereoSystem.setFavoriteSong("Queen - Killer Queen");
        bathroom.setFavoriteTemperature("35℃");
        bathroom.setFavoriteLevel("60%");

        smartHouseFacade.cameHome();
        smartHouseFacade.leaveBathroomGoSleep();
    }
}

class SmartHouseFacade {
    StereoSystem stereoSystem;
    Bathroom bathroom;
    Lights lights;

    public SmartHouseFacade(StereoSystem stereoSystem, Bathroom bathroom, Lights lights) {
        this.stereoSystem = stereoSystem;
        this.bathroom = bathroom;
        this.lights = lights;
    }

    public void cameHome() {
        stereoSystem.on();
        stereoSystem.turnOnFavoriteSong();
        bathroom.fill();
        lights.on();
    }

    public void leaveBathroomGoSleep() {
        bathroom.drain();
        stereoSystem.off();
        lights.off();
    }
}

class StereoSystem {
    private String description = "StereoSystem";
    private String favoriteSong;

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void turnOnFavoriteSong() {
        if (favoriteSong != null) {
            System.out.println("Favorite song is playing! " + favoriteSong);
        } else {
            System.out.println("No favorite song set.");
        }
    }

    public void setFavoriteSong(String favoriteSong) {
        this.favoriteSong = favoriteSong;
    }
}

class Bathroom {
    private String description = "The tub";
    private String favoriteTemperature;
    private String favoriteLevel;

    public void fill() {
        System.out.println(description + " is being filled");
        if (favoriteTemperature != null) {
            System.out.println("Temperature: " + favoriteTemperature);
        } else {
            System.out.println("No favorite temperature set.");
        }
        if (favoriteLevel != null) {
            System.out.println("Water level: " + favoriteLevel);
        } else {
            System.out.println("No favorite water level set.");
        }
    }

    public void drain() {
        System.out.println(description + " is being drained");
    }

    public void setFavoriteTemperature(String favoriteTemperature) {
        this.favoriteTemperature = favoriteTemperature;
    }

    public void setFavoriteLevel(String favoriteLevel) {
        this.favoriteLevel = favoriteLevel;
    }
}

class Lights {
    private String description = "Lights";
    private String favoriteColorTemperature;

    public void on() {
        System.out.println(description + " on");
        if (favoriteColorTemperature != null) {
            System.out.println("Color temperature is: " + favoriteColorTemperature);
        } else {
            System.out.println("No favorite color temperature set.");
        }
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void setFavoriteColorTemperature(String favoriteColorTemperature) {
        this.favoriteColorTemperature = favoriteColorTemperature;
    }
}