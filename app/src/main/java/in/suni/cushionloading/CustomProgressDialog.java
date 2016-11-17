package in.suni.cushionloading;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * @author Sunil Subramannian
 */
public class CustomProgressDialog extends Dialog {
    Context mContext;
    CardView cardView,transparentCard;
    Animation zoomin,zoomout,zoom_in,zoom_out;

    public CustomProgressDialog(Context context) {
        super(context, R.style.TransparentProgressDialog);
        this.mContext = context;

        setContentView(R.layout.progress_dialog);

        cardView = (CardView)findViewById(R.id.card_view);
        transparentCard = (CardView)findViewById(R.id.app);
        zoomin = AnimationUtils.loadAnimation(mContext,R.anim.zoom_in);
        zoomout = AnimationUtils.loadAnimation(mContext,R.anim.zoom_out);
        zoom_in = AnimationUtils.loadAnimation(mContext,R.anim.zoomin);
        zoom_out = AnimationUtils.loadAnimation(mContext,R.anim.zoomout);

    }



    public void card1_out(){
        cardView.startAnimation(zoomout);
        zoomout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                card1_in();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void card1_in(){
        cardView.startAnimation(zoomin);
        zoomin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                card1_out();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    public void card2_in(){
        transparentCard.startAnimation(zoom_in);
        zoom_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                card2_out();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void card2_out(){
        transparentCard.startAnimation(zoom_out);
        zoom_out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                card2_in();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void show() {
        super.show();
        card1_out();
        card2_in();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        zoom_in.cancel();
        zoom_out.cancel();
        zoomin.cancel();
        zoomout.cancel();

    }

}
