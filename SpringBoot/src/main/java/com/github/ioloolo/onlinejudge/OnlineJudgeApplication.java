package com.github.ioloolo.onlinejudge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 대회용 랭킹  서비스
 * 채점 기록 모두 websocket으로
 */
@SpringBootApplication
public class OnlineJudgeApplication {

    public static void main(String[] args) {

        SpringApplication.run(OnlineJudgeApplication.class, args);
    }
}
