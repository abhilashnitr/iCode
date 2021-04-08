package main.FAANG.DesignPatterns.structural.proxy.thirdParty;

import java.util.HashMap;

public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}


