/*******************************************************************************
 * Copyright 2011-2014 Sergey Tarasevich
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.fans.loader.internal.core.display;

import android.graphics.Bitmap;

import com.fans.loader.internal.core.assist.LoadedFrom;
import com.fans.loader.internal.core.imageaware.ImageAware;

/**
 * Displays {@link Bitmap} in {@link com.fans.loader.internal.core.imageaware.ImageAware}. Implementations can
 * apply some changes to Bitmap or any animation for displaying Bitmap.<br />
 * Implementations have to be thread-safe.
 *
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 * @see com.fans.loader.internal.core.imageaware.ImageAware
 * @see com.fans.loader.internal.core.assist.LoadedFrom
 * @since 1.5.6
 */
public interface BitmapDisplayer {
    /**
     * Displays bitmap in {@link com.fans.loader.internal.core.imageaware.ImageAware}.
     * <b>NOTE:</b> This method is called on UI thread so it's strongly recommended not to do any heavy work in it.
     *
     * @param bitmap     Source bitmap
     * @param imageAware {@linkplain com.fans.loader.internal.core.imageaware.ImageAware Image aware view} to
     *                   display Bitmap
     * @param loadedFrom Source of loaded image
     */
    void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom);
}
