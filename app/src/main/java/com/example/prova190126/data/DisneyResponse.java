
package com.example.prova190126.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DisneyResponse {
    @SerializedName("data")
    private List<Personagem> data;

    public List<Personagem> getData() {
        return data;
    }

    public void setData(List<Personagem> data) {
        this.data = data;
    }
}

