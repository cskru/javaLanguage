package com.kruthika.javalanguage.music_library;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AudioTrack implements Track {
    TrackType type = TrackType.AUDIO;

    private String name;
    private StringBuilder optionalDescription = new StringBuilder();
    private URL gaanaLink;
    private UUID id;

    public static Map<UUID, UUID> audioTrackList = new HashMap<>(); //categoryId

    {// Initialization block
        optionalDescription.append("Default track description");
    }

    public AudioTrack(String name, URL gaanaLink) {
        this.name = name;
        this.gaanaLink = gaanaLink;
        this.id = UUID.randomUUID();
    }

    public AudioTrack(String name, URL gaanaLink , StringBuilder optionalDescription) {
        this(name, gaanaLink); //Using another constructor
        this.optionalDescription = optionalDescription;
    }

    public TrackType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public StringBuilder getOptionalDescription() {
        return optionalDescription;
    }

    public URL getGaanaLink() {
        return gaanaLink;
    }

    public UUID getId() {
        return id;
    }

    public static Map<UUID, UUID> getAudioTrackList() {
        return audioTrackList;
    }

    @Override
    public void addTrack(UUID categoryId) {
        audioTrackList.put(this.id, categoryId);
    }


}
