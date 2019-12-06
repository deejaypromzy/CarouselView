package com.jama.carouselview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

public class CarouselView extends FrameLayout {

  private ViewPager2 viewPager2;
  private CarouselViewListener carouselViewListener;
  private int resource;
  private int size;
  private boolean isResourceSet = false;
  private boolean isSizeSet = false;

  public CarouselView(@NonNull Context context) {
    super(context);
    init(context);
  }

  public CarouselView(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  private void init(Context context) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View carouselView = inflater.inflate(R.layout.view_carousel, this);
    this.viewPager2 = carouselView.findViewById(R.id.carouselViewPager2);
  }

  public void setSize(int size) {
    this.size = size;
    this.isSizeSet = true;
  }

  public int getSize() {
    return this.size;
  }

  public void setResource(int resource) {
    this.resource = resource;
    this.isResourceSet = true;
  }

  public int getResource() {
    return this.resource;
  }

  public void show() {
    if (this.carouselViewListener == null) throw new RuntimeException("A carouselviewlistener is need");
    else if (!this.isResourceSet) throw new RuntimeException("A resource to a view is needed");
    else if (!this.isSizeSet) throw new RuntimeException("A size is needed");
    else  {
      viewPager2.setAdapter(new CarouselViewAdapter(this.carouselViewListener, this.resource, this.size));
      viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
    }
  }

}
