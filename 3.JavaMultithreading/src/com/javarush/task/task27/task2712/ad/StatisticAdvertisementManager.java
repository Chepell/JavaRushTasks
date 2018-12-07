package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance;
    private static final AdvertisementStorage videoStore = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) instance = new StatisticAdvertisementManager();
        return instance;
    }

    public List<Advertisement> activeVideoList() {
        return activeVideoList(true);
    }

    public List<Advertisement> archiveVideoList() {
        return activeVideoList(false);
    }

    private List<Advertisement> activeVideoList(boolean isActive) {
        List<Advertisement> activeList = new ArrayList<>();
        List<Advertisement> archiveList = new ArrayList<>();

            for (Advertisement ad : videoStore.list()) {
                if (ad.getHits() > 0) {
                    activeList.add(ad);
                } else {
                    archiveList.add(ad);
                }
            }
        if (isActive) {
            return activeList;
        } else {
            return archiveList;
        }
    }
}