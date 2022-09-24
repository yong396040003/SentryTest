package com.vantron.sentry

import android.content.Context
import io.sentry.*
import io.sentry.android.core.SentryAndroid

/**
 * @PackAge：com.vantron.sentry
 * @author： yong
 * @Desc： Sentry工具类
 * @Time: 2022/9/20 上午10:29
 **/
object SentryUtils {

    /**
     * 初始化Sentry
     */
    @JvmStatic
    fun init(context: Context, dsn: String) {
        SentryAndroid.init(context) { options ->
            options.dsn = dsn
            // Add a callback that will be used before the event is sent to Sentry.
            // With this callback, you can modify the event or, when returning null, also discard the event.
            options.beforeSend =
                SentryOptions.BeforeSendCallback { event: SentryEvent, _: Hint ->
                    if (SentryLevel.DEBUG == event.level) {
                        null
                    } else {
                        event
                    }
                }
        }
    }

    /**
     * 上报自定义信息
     */
    @JvmStatic
    fun captureMessage(msg: String) {
        Sentry.captureMessage(msg)
    }
}