package com.zenit.digital;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.zenit.digital.databinding.FragmentAboutUsBindingImpl;
import com.zenit.digital.databinding.FragmentCalculatorBindingImpl;
import com.zenit.digital.databinding.FragmentCatalogBindingImpl;
import com.zenit.digital.databinding.FragmentContactBindingImpl;
import com.zenit.digital.databinding.FragmentDesktopPcBuilderBindingImpl;
import com.zenit.digital.databinding.FragmentGalleryBindingImpl;
import com.zenit.digital.databinding.FragmentLaptopConfiguratorBindingImpl;
import com.zenit.digital.databinding.FragmentLoginBindingImpl;
import com.zenit.digital.databinding.FragmentMainBindingImpl;
import com.zenit.digital.databinding.FragmentMainTopicBindingImpl;
import com.zenit.digital.databinding.FragmentMissionBindingImpl;
import com.zenit.digital.databinding.FragmentSocialBindingImpl;
import com.zenit.digital.databinding.FragmentVideoBindingImpl;
import com.zenit.digital.databinding.ItemCatalogProductBindingImpl;
import com.zenit.digital.databinding.ItemMainMenuBindingImpl;
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
  private static final int LAYOUT_FRAGMENTABOUTUS = 1;

  private static final int LAYOUT_FRAGMENTCALCULATOR = 2;

  private static final int LAYOUT_FRAGMENTCATALOG = 3;

  private static final int LAYOUT_FRAGMENTCONTACT = 4;

  private static final int LAYOUT_FRAGMENTDESKTOPPCBUILDER = 5;

  private static final int LAYOUT_FRAGMENTGALLERY = 6;

  private static final int LAYOUT_FRAGMENTLAPTOPCONFIGURATOR = 7;

  private static final int LAYOUT_FRAGMENTLOGIN = 8;

  private static final int LAYOUT_FRAGMENTMAIN = 9;

  private static final int LAYOUT_FRAGMENTMAINTOPIC = 10;

  private static final int LAYOUT_FRAGMENTMISSION = 11;

  private static final int LAYOUT_FRAGMENTSOCIAL = 12;

  private static final int LAYOUT_FRAGMENTVIDEO = 13;

  private static final int LAYOUT_ITEMCATALOGPRODUCT = 14;

  private static final int LAYOUT_ITEMMAINMENU = 15;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(15);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_about_us, LAYOUT_FRAGMENTABOUTUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_calculator, LAYOUT_FRAGMENTCALCULATOR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_catalog, LAYOUT_FRAGMENTCATALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_contact, LAYOUT_FRAGMENTCONTACT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_desktop_pc_builder, LAYOUT_FRAGMENTDESKTOPPCBUILDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_gallery, LAYOUT_FRAGMENTGALLERY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_laptop_configurator, LAYOUT_FRAGMENTLAPTOPCONFIGURATOR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_main, LAYOUT_FRAGMENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_main_topic, LAYOUT_FRAGMENTMAINTOPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_mission, LAYOUT_FRAGMENTMISSION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_social, LAYOUT_FRAGMENTSOCIAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.fragment_video, LAYOUT_FRAGMENTVIDEO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.item_catalog_product, LAYOUT_ITEMCATALOGPRODUCT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.zenit.digital.R.layout.item_main_menu, LAYOUT_ITEMMAINMENU);
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
        case  LAYOUT_FRAGMENTABOUTUS: {
          if ("layout/fragment_about_us_0".equals(tag)) {
            return new FragmentAboutUsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_about_us is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCALCULATOR: {
          if ("layout/fragment_calculator_0".equals(tag)) {
            return new FragmentCalculatorBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_calculator is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCATALOG: {
          if ("layout/fragment_catalog_0".equals(tag)) {
            return new FragmentCatalogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_catalog is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCONTACT: {
          if ("layout/fragment_contact_0".equals(tag)) {
            return new FragmentContactBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_contact is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTDESKTOPPCBUILDER: {
          if ("layout/fragment_desktop_pc_builder_0".equals(tag)) {
            return new FragmentDesktopPcBuilderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_desktop_pc_builder is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGALLERY: {
          if ("layout/fragment_gallery_0".equals(tag)) {
            return new FragmentGalleryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_gallery is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLAPTOPCONFIGURATOR: {
          if ("layout/fragment_laptop_configurator_0".equals(tag)) {
            return new FragmentLaptopConfiguratorBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_laptop_configurator is invalid. Received: " + tag);
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
        case  LAYOUT_FRAGMENTMAINTOPIC: {
          if ("layout/fragment_main_topic_0".equals(tag)) {
            return new FragmentMainTopicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_main_topic is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMISSION: {
          if ("layout/fragment_mission_0".equals(tag)) {
            return new FragmentMissionBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_mission is invalid. Received: " + tag);
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
        case  LAYOUT_ITEMCATALOGPRODUCT: {
          if ("layout/item_catalog_product_0".equals(tag)) {
            return new ItemCatalogProductBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_catalog_product is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMMAINMENU: {
          if ("layout/item_main_menu_0".equals(tag)) {
            return new ItemMainMenuBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_main_menu is invalid. Received: " + tag);
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
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(15);

    static {
      sKeys.put("layout/fragment_about_us_0", com.zenit.digital.R.layout.fragment_about_us);
      sKeys.put("layout/fragment_calculator_0", com.zenit.digital.R.layout.fragment_calculator);
      sKeys.put("layout/fragment_catalog_0", com.zenit.digital.R.layout.fragment_catalog);
      sKeys.put("layout/fragment_contact_0", com.zenit.digital.R.layout.fragment_contact);
      sKeys.put("layout/fragment_desktop_pc_builder_0", com.zenit.digital.R.layout.fragment_desktop_pc_builder);
      sKeys.put("layout/fragment_gallery_0", com.zenit.digital.R.layout.fragment_gallery);
      sKeys.put("layout/fragment_laptop_configurator_0", com.zenit.digital.R.layout.fragment_laptop_configurator);
      sKeys.put("layout/fragment_login_0", com.zenit.digital.R.layout.fragment_login);
      sKeys.put("layout/fragment_main_0", com.zenit.digital.R.layout.fragment_main);
      sKeys.put("layout/fragment_main_topic_0", com.zenit.digital.R.layout.fragment_main_topic);
      sKeys.put("layout/fragment_mission_0", com.zenit.digital.R.layout.fragment_mission);
      sKeys.put("layout/fragment_social_0", com.zenit.digital.R.layout.fragment_social);
      sKeys.put("layout/fragment_video_0", com.zenit.digital.R.layout.fragment_video);
      sKeys.put("layout/item_catalog_product_0", com.zenit.digital.R.layout.item_catalog_product);
      sKeys.put("layout/item_main_menu_0", com.zenit.digital.R.layout.item_main_menu);
    }
  }
}
