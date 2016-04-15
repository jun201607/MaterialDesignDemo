package ren.solid.materialdesigndemo.fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;

import ren.solid.materialdesigndemo.R;
import ren.solid.materialdesigndemo.fragment.base.BaseFragment;
import ren.solid.skinloader.listener.ILoaderListener;
import ren.solid.skinloader.load.SkinManager;

/**
 * Created by _SOLID
 * Date:2016/4/14
 * Time:10:44
 */
public class ChangeSkinFragment extends BaseFragment {

    private static String TAG = "ChangeSkinFragment";

    private static final String SKIN_BROWN_NAME = "skin_brown.skin";
    private static final String SKIN_BLACK_NAME = "skin_black.skin";
    private static final String SKIN_DIR = Environment
            .getExternalStorageDirectory() + File.separator;

    @Override
    protected View setContentView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_chang_skin, container, false);
    }

    @Override
    protected void initView() {
        customFindViewById(R.id.ll_green).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SkinManager.getInstance().restoreDefaultTheme();
            }
        });
        customFindViewById(R.id.ll_brown).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File skin = new File(SKIN_DIR + SKIN_BROWN_NAME);
                if (skin == null || !skin.exists()) {
                    Toast.makeText(getMContext(), "请检查" + SKIN_DIR + "是否存在", Toast.LENGTH_SHORT).show();
                    return;
                }
                SkinManager.getInstance().load(skin.getAbsolutePath(),
                        new ILoaderListener() {
                            @Override
                            public void onStart() {
                                Log.e(TAG, "loadSkinStart");
                            }

                            @Override
                            public void onSuccess() {
                                Log.e(TAG, "loadSkinSuccess");
                                Toast.makeText(getMContext(), "切换成功", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailed() {
                                Log.e(TAG, "loadSkinFail");
                                Toast.makeText(getMContext(), "切换失败", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        customFindViewById(R.id.ll_black).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File skin = new File(SKIN_DIR + SKIN_BLACK_NAME);
                if (skin == null || !skin.exists()) {
                    Toast.makeText(getMContext(), "请检查" + SKIN_DIR + "是否存在", Toast.LENGTH_SHORT).show();
                    return;
                }
                SkinManager.getInstance().load(skin.getAbsolutePath(),
                        new ILoaderListener() {
                            @Override
                            public void onStart() {
                                Log.e(TAG, "loadSkinStart");
                            }

                            @Override
                            public void onSuccess() {
                                Log.e(TAG, "loadSkinSuccess");
                                Toast.makeText(getMContext(), "切换成功", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailed() {
                                Log.e(TAG, "loadSkinFail");
                                Toast.makeText(getMContext(), "切换失败", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

}