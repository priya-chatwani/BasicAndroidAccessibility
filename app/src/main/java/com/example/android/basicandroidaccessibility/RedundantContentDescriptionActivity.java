// Copyright 2016 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.example.android.basicandroidaccessibility;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class RedundantContentDescriptionActivity extends AppCompatActivity {

    private static List<CharSequence> redundantWords = new ArrayList<>();
    static {
        redundantWords.add("button");
        redundantWords.add("imagebutton");
        redundantWords.add("imageview");
        redundantWords.add("view");
    }

    private ImageButton share_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redundant_content_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        share_button = (ImageButton) findViewById(R.id.share_button);
        CharSequence contentDescription = share_button.getContentDescription();

        for (CharSequence redundantWord : redundantWords) {
            if (contentDescription.toString().toLowerCase().contains(redundantWord)) {
                updateButtonDesc();
            }
        }
    }

    private void updateButtonDesc() {
        System.out.println("Updating desc");
        share_button.setContentDescription("Share");
    }
}
