package com.retrofit.and_rxjava.entity;

import android.util.Log;

import java.util.List;

/**
 * Created by mbc on 19-7-5
 * Description:
 */
public class Translation {


    private int status;

    private content content;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Translation.content getContent() {
        return content;
    }

    public void setContent(Translation.content content) {
        this.content = content;
    }

    public static class content {
        private String ph_am;
        private String ph_am_mp3;
        private String ph_en;
        private String ph_tts_mp3;
        private List<String> word_mean;

        public String getPh_am() {
            return ph_am;
        }

        public void setPh_am(String ph_am) {
            this.ph_am = ph_am;
        }

        public String getPh_am_mp3() {
            return ph_am_mp3;
        }

        public void setPh_am_mp3(String ph_am_mp3) {
            this.ph_am_mp3 = ph_am_mp3;
        }

        public String getPh_en() {
            return ph_en;
        }

        public void setPh_en(String ph_en) {
            this.ph_en = ph_en;
        }

        public String getPh_tts_mp3() {
            return ph_tts_mp3;
        }

        public void setPh_tts_mp3(String ph_tts_mp3) {
            this.ph_tts_mp3 = ph_tts_mp3;
        }

        public List<String> getWord_mean() {
            return word_mean;
        }

        public void setWord_mean(List<String> word_mean) {
            this.word_mean = word_mean;
        }

        //定义 输出返回数据 的方法
        public String string() {
            return "ph_am -- " + ph_am + "\n" +
                    "ph_am_mp3 -- " + ph_am_mp3 + "\n" +
                    "ph_en -- " + ph_en + "\n" +
                    "ph_tts_mp3 -- " + ph_tts_mp3 + "\n";
        }
    }
}
