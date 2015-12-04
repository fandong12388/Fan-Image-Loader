/*******************************************************************************
 * Copyright 2011-2013 Sergey Tarasevich
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
package com.fans.loader.internal.core;

import com.fans.loader.internal.core.assist.ImageSize;
import com.fans.loader.internal.core.imageaware.ImageAware;
import com.fans.loader.internal.core.listener.ImageLoadingListener;
import com.fans.loader.internal.core.listener.ImageLoadingProgressListener;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Information for load'n'display image task
 *
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 * @see com.fans.loader.internal.utils.MemoryCacheUtils
 * @see DisplayImageOptions
 * @see ImageLoadingListener
 * @see com.fans.loader.internal.core.listener.ImageLoadingProgressListener
 * @since 1.3.1
 */
final class ImageLoadingInfo {

    final String uri;
    final String memoryCacheKey;
    final ImageAware imageAware;
    final ImageSize targetSize;
    final DisplayImageOptions options;
    final ImageLoadingListener listener;
    final ImageLoadingProgressListener progressListener;
    final ReentrantLock loadFromUriLock;

    public ImageLoadingInfo(String uri, ImageAware imageAware, ImageSize targetSize, String memoryCacheKey,
                            DisplayImageOptions options, ImageLoadingListener listener,
                            ImageLoadingProgressListener progressListener, ReentrantLock loadFromUriLock) {
        this.uri = uri;
        this.imageAware = imageAware;
        this.targetSize = targetSize;
        this.options = options;
        this.listener = listener;
        this.progressListener = progressListener;
        this.loadFromUriLock = loadFromUriLock;
        this.memoryCacheKey = memoryCacheKey;
    }
}
