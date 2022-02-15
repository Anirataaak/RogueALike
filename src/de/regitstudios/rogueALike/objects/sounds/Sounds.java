package de.regitstudios.rogueALike.objects.sounds;

public interface Sounds {

    String SOUND_PATH = "/Sound/";

    Sound SOUND_OVERWORLD_THEME = new Sound(SOUND_PATH, "overworld_soundtrack.wav");

    Sound SOUND_CHEST_OPEN = new Sound(SOUND_PATH, "chest_open.wav");
    Sound SOUND_KEY_PICKUP = new Sound(SOUND_PATH, "key_pickup.wav");
    Sound SOUND_GEM_PICKUP = new Sound(SOUND_PATH, "gem_pickup.wav");
    Sound SOUND_ERROR = new Sound(SOUND_PATH, "error.wav");
    Sound SOUND_PICKUP = new Sound(SOUND_PATH, "pickup.wav");
}
