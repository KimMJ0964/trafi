package com.skt.main.service;

import java.util.List;

import com.skt.festival.model.vo.Festival;
import com.skt.tourist.model.vo.Tourist;

public interface MainPageService {
	List<Tourist> getTopTourists();

    List<Tourist> getTopTouristsTwo();

    List<Festival> getFestivalIntro();
}
