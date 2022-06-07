package com.tokioschool.navigationpractica.features.home.adapters.viewholders;

import android.graphics.drawable.Drawable;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.tokioschool.navigationpractica.R;
import com.tokioschool.navigationpractica.databinding.ItemlayoutListaCochesBinding;
import com.tokioschool.navigationpractica.domain.CarItem;
import com.tokioschool.navigationpractica.features.home.adapters.ListaCochesAdapter;

public class ListaCochesViewHolder extends RecyclerView.ViewHolder {
    private final ItemlayoutListaCochesBinding binding;
    private final ListaCochesAdapter.OnItemCarClick listener;

    public ListaCochesViewHolder(ItemlayoutListaCochesBinding bindingView, ListaCochesAdapter.OnItemCarClick listener) {
        super(bindingView.getRoot());
        this.binding=bindingView;
        this.listener=listener;
    }

    public void bind(CarItem carItem) {
        binding.itemlayoutListacocheName.setText(carItem.getCarType());
        binding.itemlayoutListcarImg.setImageResource(getImageFromTypeCar(carItem.getCarType()));
        tintBackgroundView(carItem.getCarType());
        binding.itemlayoutListacochePrice.setText(itemView.getContext().getString(R.string.price_car,carItem.getPrice()));
        binding.itemlayoutListcarBackground.setOnClickListener(view -> listener.onItemClickCar(carItem));
    }

    private void tintBackgroundView(String carType) {

        switch (carType){
            case "airplane":
                createTintBackground(R.color.airplane);
                break;
            case "bus":
                createTintBackground(R.color.bus);
                break;
            case "electricCar":
                createTintBackground(R.color.electricCar);
                break;
            case "flyingCar":
                createTintBackground(R.color.flyingCar);
                break;
            case "motorHome":
                createTintBackground(R.color.motorHome);
                break;
            case "pickUpCar":
                createTintBackground(R.color.pickUpCar);
                break;
            case "sportCar":
                createTintBackground(R.color.sportCar);
                break;
            default:
                createTintBackground(R.color.clasicCar);
                break;
        }
    }

    private void createTintBackground(@ColorRes int color){
        Drawable tintDrawable=binding.itemlayoutListcarBackground.getBackground();
        tintDrawable=DrawableCompat.wrap(tintDrawable);
        DrawableCompat.setTint(tintDrawable, ContextCompat.getColor(itemView.getContext(),color));
    }

    private int getImageFromTypeCar(String carType) {
        switch (carType){
            case "airplane":
                return R.drawable.img_vehicle_air_plane;
            case "bus":
                return R.drawable.img_vehicle_bus;
            case "electricCar":
                return R.drawable.img_vehicle_electric_car;
            case "flyingCar":
                return R.drawable.img_vehicle_flying_car;
            case "motorHome":
                return R.drawable.img_vehicle_motor_home;
            case "pickUpCar":
                return R.drawable.img_vehicle_pick_up_car;
            case "sportCar":
                return R.drawable.img_vehicle_sport_car;
            default:
                return R.drawable.img_vehicle_classic_car;
        }
    }
}
