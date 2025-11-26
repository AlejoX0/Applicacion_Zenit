package com.zenit.digital;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.zenit.digital.databinding.FragmentCatalogBindingImpl;
import com.zenit.digital.databinding.FragmentGalleryBindingImpl;
import com.zenit.digital.databinding.FragmentLoginBindingImpl;
import com.zenit.digital.databinding.FragmentMainBindingImpl;
import com.zenit.digital.databinding.FragmentSocialBindingImpl;
import com.zenit.digital.databinding.FragmentVideoBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTCATALOG = 1;

  private static final int LAYOUT_FRAGMENTGALLERY = 2;

  private static final int LAYOUT_FRAGMENTLOGIN = 3;

  private static final int LAYOUT_FRAGMENTMAIN = 4;

  private static final int LAYOUT_FRAGMENTSOCIAL = 5;

  private static final int LAYOUT_FRAGMENTVIDEO = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_catalog, LAYOUT_FRAGMENTCATALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_gallery, LAYOUT_FRAGMENTGALLERY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_main, LAYOUT_FRAGMENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_social, LAYOUT_FRAGMENTSOCIAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_video, LAYOUT_FRAGMENTVIDEO);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTCATALOG: {
          if ("layout/fragment_catalog_0".equals(tag)) {
            return new FragmentCatalogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_catalog is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGALLERY: {
          if ("layout/fragment_gallery_0".equals(tag)) {
            return new FragmentGalleryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_gallery is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMAIN: {
          if ("layout/fragment_main_0".equals(tag)) {
            return new FragmentMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSOCIAL: {
          if ("layout/fragment_social_0".equals(tag)) {
            return new FragmentSocialBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_social is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTVIDEO: {
          if ("layout/fragment_video_0".equals(tag)) {
            return new FragmentVideoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_video is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/fragment_catalog_0", com.zenit.digital.R.layout.fragment_catalog);
      sKeys.put("layout/fragment_gallery_0", com.zenit.digital.R.layout.fragment_gallery);
      sKeys.put("layout/fragment_login_0", com.zenit.digital.R.layout.fragment_login);
      sKeys.put("layout/fragment_main_0", com.zenit.digital.R.layout.fragment_main);
      sKeys.put("layout/fragment_social_0", com.zenit.digital.R.layout.fragment_social);
      sKeys.put("layout/fragment_video_0", com.zenit.digital.R.layout.fragment_video);
    }
  }
}
