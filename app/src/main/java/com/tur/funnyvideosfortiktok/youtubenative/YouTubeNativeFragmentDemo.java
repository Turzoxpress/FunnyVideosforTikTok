/*
 * Apache License
 * Version 2.0, January 2004
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION
 *
 * Copyright (c) 2018 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.tur.funnyvideosfortiktok.youtubenative;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tur.funnyvideosfortiktok.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class YouTubeNativeFragmentDemo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView view = (RecyclerView) inflater.inflate(R.layout.youtube_native_fragment, container, false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        view.setLayoutManager(linearLayoutManager);

        Bundle arguments = getArguments();
        int playerType = arguments.getInt("playerType");

        ArrayList<String> videoIds = new ArrayList<>();
        videoIds.add("bvcrQSZ_spI");
        videoIds.add("K8nzS3U0Yww");
        videoIds.add("Y6jtvGoOtX8");
        videoIds.add("hsKV0NU2KZM");
        videoIds.add("UWRP0Xoz8_8");

        videoIds.add("0NS3FI1R640");
        videoIds.add("_xnYOe_Gi5I");
        videoIds.add("AoLSVbPd5fI");
        videoIds.add("_7gemzV58uk");
        videoIds.add("siJOf95dUNc");

        videoIds.add("siJOf95dUNc");
        videoIds.add("JWyzd_jLFnA");
        videoIds.add("MbAvMhA7-JU");
        videoIds.add("L06vUVd9lGM");
        videoIds.add("kaZK63uUzgg");

        videoIds.add("akfPXqgmpV4");
        videoIds.add("fm_xQ5gv7gg");
        videoIds.add("h0as6f3iKog");
        videoIds.add("jF6zUGib-t8");
        videoIds.add("jF6zUGib-t8");

        videoIds.add("iWizxOzeJps");
        videoIds.add("Q5ZoYeOkKC4");
        videoIds.add("Fdlw1yMgd3A");
        videoIds.add("clL3paZhM4A");
        videoIds.add("xjZc_ni5RAM");

        videoIds.add("NNPXqqrBrPU");
        videoIds.add("7x-OjjOamjI");
        videoIds.add("7IrNm_YKc28");
        videoIds.add("tzJKtW2t4iA");
        videoIds.add("kXSbiPIZWSU");



        YouTubePlayerAdapter youTubePlayerAdapter = new YouTubePlayerAdapter(videoIds, this, playerType);
        view.setAdapter(youTubePlayerAdapter);

        return view;
    }
}
