package com.gfz.mvp.utils;

/**
 * Created by gaofengze on 2020/10/26
 */
public class Content {
    public static String content = "{\n" +
            "    \"code\": 200,\n" +
            "    \"message\": \"[ExtTool]查询用户最近10条错误日志[OK]\",\n" +
            "    \"result\": {\n" +
            "        \"userErrorList\": [\n" +
            "            {\n" +
            "                \"error_msg\": \"qua = unknown\r\nversionName = 9.821\r\nversionCode = 98210\r\nimei = empty_imei\r\nuid = s16006155018414\r\nnetwork = unknown\r\nmodel = JSN-AL00\r\napi-level = 29 10\r\ncpu-core = 8\r\nprocess = com.towords\r\nfreeMemory = 1030584\r\ntotalMemory = 5826828\r\nbackground = false\r\ntime = 1119\r\nthread-time = 1004\r\ntime-start = 10-26 15:22:18.775\r\ntime-end = 10-26 15:22:19.894\r\ncpu-busy = false\r\ncpu-rate = 10-26 15:21:29.148 180% \r\n\r\nstack = 10-26 15:22:19.589\r\n\r\nandroid.content.res.StringBlock.get(StringBlock.java:90)\r\nandroid.content.res.ApkAssets.getStringFromPool(ApkAssets.java:140)\r\nandroid.content.res.AssetManager.getPooledStringForCookie(AssetManager.java:865)\r\nandroid.content.res.TypedArray.loadStringValueAt(TypedArray.java:1606)\r\nandroid.content.res.TypedArray.getValueAt(TypedArray.java:1585)\r\nandroid.content.res.TypedArray.getColorStateList(TypedArray.java:673)\r\nandroid.widget.TextView.readTextAppearance(TextView.java:4018)\r\nandroid.widget.TextView.<init>(TextView.java:1063)\r\nandroid.widget.TextView.<init>(TextView.java:1000)\r\nandroidx.appcompat.widget.AppCompatTextView.<init>(AppCompatTextView.java:99)\r\nskin.support.widget.SkinCompatTextView.<init>(SkinCompatTextView.java:25)\r\nskin.support.widget.SkinCompatTextView.<init>(SkinCompatTextView.java:21)\r\nskin.support.app.SkinAppCompatViewInflater.createViewFromFV(SkinAppCompatViewInflater.java:78)\r\nskin.support.app.SkinAppCompatViewInflater.createView(SkinAppCompatViewInflater.java:51)\r\nskin.support.app.SkinCompatViewInflater.createViewFromInflater(SkinCompatViewInflater.java:77)\r\nskin.support.app.SkinCompatViewInflater.createView(SkinCompatViewInflater.java:46)\r\nskin.support.app.SkinCompatDelegate.createView(SkinCompatDelegate.java:70)\r\nskin.support.app.SkinCompatDelegate.onCreateView(SkinCompatDelegate.java:31)\r\nandroid.view.LayoutInflater.tryCreateView(LayoutInflater.java:1071)\r\nandroid.view.LayoutInflater.createViewFromTag(LayoutInflater.java:1007)\r\nandroid.view.LayoutInflater.createViewFromTag(LayoutInflater.java:971)\r\nandroid.view.LayoutInflater.rInflate(LayoutInflater.java:1133)\r\nandroid.view.LayoutInflater.rInflateChildren(LayoutInflater.java:1094)\r\nandroid.view.LayoutInflater.rInflate(LayoutInflater.java:1136)\r\nandroid.view.LayoutInflater.rInflateChildren(LayoutInflater.java:1094)\r\nandroid.view.LayoutInflater.rInflate(LayoutInflater.java:1136)\r\nandroid.view.LayoutInflater.rInflateChildren(LayoutInflater.java:1094)\r\nandroid.view.LayoutInflater.rInflate(LayoutInflater.java:1136)\r\nandroid.view.LayoutInflater.rInflateChildren(LayoutInflater.java:1094)\r\nandroid.view.LayoutInflater.inflate(LayoutInflater.java:692)\r\nandroid.view.LayoutInflater.inflate(LayoutInflater.java:536)\r\ncom.towords.base.recyclerview.BaseRecyclerViewAdapter.getView(BaseRecyclerViewAdapter.java:567)\r\ncom.towords.base.recyclerview.BaseRecyclerViewAdapter.getViewByViewType(BaseRecyclerViewAdapter.java:545)\r\ncom.towords.base.recyclerview.BaseRecyclerViewAdapter.onCreateViewHolder(BaseRecyclerViewAdapter.java:113)\r\ncom.towords.base.recyclerview.BaseRecyclerViewAdapter.onCreateViewHolder(BaseRecyclerViewAdapter.java:34)\r\nandroidx.recyclerview.widget.RecyclerView$Adapter.createViewHolder(RecyclerView.java:7078)\r\nandroidx.recyclerview.widget.RecyclerView$Recycler.tryGetViewHolderForPositionByDeadline(RecyclerView.java:6235)\r\nandroidx.recyclerview.widget.RecyclerView$Recycler.getViewForPosition(RecyclerView.java:6118)\r\nandroidx.recyclerview.widget.RecyclerView$Recycler.getViewForPosition(RecyclerView.java:6114)\r\nandroidx.recyclerview.widget.LinearLayoutManager$LayoutState.next(LinearLayoutManager.java:2303)\r\nandroidx.recyclerview.widget.LinearLayoutManager.layoutChunk(LinearLayoutManager.java:1627)\r\nandroidx.recyclerview.widget.LinearLayoutManager.fill(LinearLayoutManager.java:1587)\r\nandroidx.recyclerview.widget.LinearLayoutManager.onLayoutChildren(LinearLayoutManager.java:665)\r\ncom.towords.fragment.discovery.FragmentBaseExperience$6.onLayoutChildren(FragmentBaseExperience.java:382)\r\nandroidx.recyclerview.widget.RecyclerView.dispatchLayoutStep2(RecyclerView.java:4134)\r\nandroidx.recyclerview.widget.RecyclerView.onMeasure(RecyclerView.java:3540)\r\nandroid.view.View.measure(View.java:24742)\r\nandroid.view.ViewGroup.measureChildWithMargins(ViewGroup.java:6903)\r\nandroid.widget.LinearLayout.measureChildBeforeLayout(LinearLayout.java:1562)\r\nandroid.widget.LinearLayout.measureVertical(LinearLayout.java:849)\r\nandroid.widget.LinearLayout.onMeasure(LinearLayout.java:728)\r\nandroid.view.View.measure(View.java:24742)\r\nandroidx.core.widget.NestedScrollView.measureChildWithMargins(NestedScrollView.java:1534)\r\nandroid.widget.FrameLayout.onMeasure(FrameLayout.java:194)\r\nandroidx.core.widget.NestedScrollView.onMeasure(NestedScrollView.java:581)\r\nandroid.view.View.measure(View.java:24742)\r\nandroid.widget.RelativeLayout.measureChildHorizontal(RelativeLayout.java:735)\r\nandroid.widget.RelativeLayout.onMeasure(RelativeLayout.java:481)\r\nandroid.view.View.measure(View.java:24742)\r\nandroid.view.ViewGroup.measureChildWithMargins(ViewGroup.j\",\n" +
            "                \"create_time\": \"Oct 26, 2020 3:22:19 PM\",\n" +
            "                \"user_id\": \"s16006155018414\",\n" +
            "                \"user_action_type\": \"CLIENT_ANDROID\",\n" +
            "                \"id\": 20726\n" +
            "            },\n" +
            "            {\n" +
            "                \"error_msg\": \"qua = unknown\r\nversionName = 9.821\r\nversionCode = 98210\r\nimei = empty_imei\r\nuid = s16006155018414\r\nnetwork = unknown\r\nmodel = JSN-AL00\r\napi-level = 29 10\r\ncpu-core = 8\r\nprocess = com.towords\r\nfreeMemory = 797476\r\ntotalMemory = 5826828\r\nbackground = false\r\ntime = 1092\r\nthread-time = 45\r\ntime-start = 10-26 15:19:39.409\r\ntime-end = 10-26 15:19:40.501\r\ncpu-busy = false\r\ncpu-rate = 10-26 15:19:38.980 208% \r\n\r\nstack = 10-26 15:19:40.224\r\n\r\nandroid.graphics.HardwareRenderer.nSetStopped(Native Method)\r\nandroid.graphics.HardwareRenderer.setStopped(HardwareRenderer.java:466)\r\nandroid.view.ViewRootImpl.performDraw(ViewRootImpl.java:3682)\r\nandroid.view.ViewRootImpl.performTraversals(ViewRootImpl.java:2954)\r\nandroid.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1857)\r\nandroid.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:8089)\r\nandroid.view.Choreographer$CallbackRecord.run(Choreographer.java:1057)\r\nandroid.view.Choreographer.doCallbacks(Choreographer.java:875)\r\nandroid.view.Choreographer.doFrame(Choreographer.java:776)\r\nandroid.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:1042)\r\nandroid.os.Handler.handleCallback(Handler.java:888)\r\nandroid.os.Handler.dispatchMessage(Handler.java:100)\r\nandroid.os.Looper.loop(Looper.java:213)\r\nandroid.app.ActivityThread.main(ActivityThread.java:8178)\r\njava.lang.reflect.Method.invoke(Native Method)\r\ncom.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:513)\r\ncom.android.internal.os.ZygoteInit.main(ZygoteInit.java:1101)\r\n\r\n\r\n\",\n" +
            "                \"create_time\": \"Oct 26, 2020 3:19:40 PM\",\n" +
            "                \"user_id\": \"s16006155018414\",\n" +
            "                \"user_action_type\": \"CLIENT_ANDROID\",\n" +
            "                \"id\": 20724\n" +
            "            },\n" +
            "            {\n" +
            "                \"error_msg\": \"qua = unknown\r\nversionName = 9.821\r\nversionCode = 98210\r\nimei = empty_imei\r\nuid = s16006155018414\r\nnetwork = unknown\r\nmodel = JSN-AL00\r\napi-level = 29 10\r\ncpu-core = 8\r\nprocess = com.towords\r\nfreeMemory = 861616\r\ntotalMemory = 5826828\r\nbackground = false\r\ntime = 1432\r\nthread-time = 874\r\ntime-start = 10-26 15:19:37.720\r\ntime-end = 10-26 15:19:39.152\r\ncpu-busy = false\r\ncpu-rate = 10-26 15:19:38.980 208% \r\n\r\nstack = 10-26 15:19:38.579\r\n\r\ncom.android.org.conscrypt.NativeCrypto.EVP_DigestUpdate(Native Method)\r\ncom.android.org.conscrypt.OpenSSLMessageDigestJDK.engineUpdate(OpenSSLMessageDigestJDK.java:103)\r\njava.security.MessageDigest$Delegate.engineUpdate(MessageDigest.java:626)\r\njava.security.MessageDigest.update(MessageDigest.java:362)\r\ncom.android.org.bouncycastle.crypto.digests.OpenSSLDigest.update(OpenSSLDigest.java:65)\r\ncom.android.org.bouncycastle.crypto.macs.HMac.doFinal(HMac.java:210)\r\ncom.android.org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator.F(PKCS5S2ParametersGenerator.java:72)\r\ncom.android.org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator.generateDerivedKey(PKCS5S2ParametersGenerator.java:103)\r\ncom.android.org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator.generateDerivedParameters(PKCS5S2ParametersGenerator.java:122)\r\ncom.android.org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator.generateDerivedMacParameters(PKCS5S2ParametersGenerator.java:158)\r\ncom.android.org.bouncycastle.jcajce.provider.symmetric.util.PBE$Util.makePBEMacParameters(PBE.java:425)\r\ncom.android.org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF2$BasePBKDF2.engineGenerateSecret(PBEPBKDF2.java:256)\r\njavax.crypto.SecretKeyFactory.generateSecret(SecretKeyFactory.java:524)\r\ncom.huawei.agconnect.config.a.e.a(Unknown Source:38)\r\ncom.huawei.agconnect.config.a.g.<init>(Unknown Source:57)\r\ncom.huawei.agconnect.config.a.a.getString(Unknown Source:45)\r\ncom.huawei.agconnect.config.a.a.getString(Unknown Source:1)\r\ncom.huawei.hms.common.util.AGCUtils.getAppId(AGCUtils.java:55)\r\ncom.huawei.hms.utils.Util.getAppId(Util.java:104)\r\ncom.huawei.hms.common.HuaweiApi.a(HuaweiApi.java:169)\r\ncom.huawei.hms.common.HuaweiApi.<init>(HuaweiApi.java:83)\r\ncom.huawei.hms.iap.b.<init>(IapClientImpl.java:106)\r\ncom.huawei.hms.iap.Iap.getIapClient(Iap.java:32)\r\ncom.towords.pay.IapRequestManager.checkClient(IapRequestManager.java:694)\r\ncom.towords.pay.IapRequestManager.updateHWStatus(IapRequestManager.java:149)\r\ncom.towords.activity.WelcomeActivity.initView(WelcomeActivity.java:115)\r\ncom.towords.base.BaseActivity.onCreate(BaseActivity.java:95)\r\nandroid.app.Activity.performCreate(Activity.java:8086)\r\nandroid.app.Activity.performCreate(Activity.java:8074)\r\nandroid.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1313)\r\nandroid.app.ActivityThread.performLaunchActivity(ActivityThread.java:3755)\r\nandroid.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3961)\r\nandroid.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:91)\r\nandroid.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:149)\r\nandroid.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:103)\r\nandroid.app.ActivityThread$H.handleMessage(ActivityThread.java:2386)\r\nandroid.os.Handler.dispatchMessage(Handler.java:107)\r\nandroid.os.Looper.loop(Looper.java:213)\r\nandroid.app.ActivityThread.main(ActivityThread.java:8178)\r\njava.lang.reflect.Method.invoke(Native Method)\r\ncom.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:513)\r\ncom.android.internal.os.ZygoteInit.main(ZygoteInit.java:1101)\r\n\r\n\r\n\",\n" +
            "                \"create_time\": \"Oct 26, 2020 3:19:38 PM\",\n" +
            "                \"user_id\": \"s16006155018414\",\n" +
            "                \"user_action_type\": \"CLIENT_ANDROID\",\n" +
            "                \"id\": 20723\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";
}
