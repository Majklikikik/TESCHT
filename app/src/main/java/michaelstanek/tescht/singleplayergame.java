package michaelstanek.tescht;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class singleplayergame extends AppCompatActivity {
    class Shipdate{
        int length;
        char orientation;
        public Shipdate(int i, char s){
            this.length=i;
            this.orientation=s;
        }
    }
    class MyDragShadowBuilder extends View.DragShadowBuilder {
        int xratio, yratio;
        public MyDragShadowBuilder(){super();}
        public MyDragShadowBuilder(View view, int yratio, int xratio){
            super(view);
            this.xratio=xratio;
            this.yratio=yratio;
        }
        @Override
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint){
            //super.onProvideShadowMetrics(shadowSize, shadowTouchPoint);
            shadowSize.set(getView().getWidth(),getView().getHeight());
            shadowTouchPoint.set(shadowSize.x/xratio,shadowSize.y/yratio);

        }

    }
    private singleplayergame ischthis=this;

    private Field p1;
    private Field p2;
    private int imageviewid5;
    int sts15;
    int sts14;
    int sts13;
    int sts12;
private void InitializeSomething(Intent intent){
    String st5 = intent.getStringExtra(startsingleplayer.EXTRA_MESSAGE5);
    String st4 = intent.getStringExtra(startsingleplayer.EXTRA_MESSAGE4);
    String st3 = intent.getStringExtra(startsingleplayer.EXTRA_MESSAGE3);
    String st2 = intent.getStringExtra(startsingleplayer.EXTRA_MESSAGE2);
    TextView text;
    //set the Textviews to show how many Ships there are to set
    text = (TextView) findViewById(R.id.textView22);
    text.setText(st5);
    text = (TextView) findViewById(R.id.textView23);
    text.setText(st4);
    text = (TextView) findViewById(R.id.textView24);
    text.setText(st3);
    text = (TextView) findViewById(R.id.textView25);
    text.setText(st2);
    //set the ints which show the same
    sts15 = Integer.valueOf(st5);
    sts14 = Integer.valueOf(st4);
    sts13 = Integer.valueOf(st3);
    sts12 = Integer.valueOf(st2);
    }

    private void increase(int i){
        TextView tex;
        switch (i){
            case 5:
                sts15++;
                tex=(TextView) findViewById(R.id.textView22);
                tex.setText(String.valueOf(sts15));
                break;
            case 4:
                sts14++;
                tex=(TextView) findViewById(R.id.textView23);
                tex.setText(String.valueOf(sts14));
                break;
            case 3:
                sts13++;
                tex=(TextView) findViewById(R.id.textView24);
                tex.setText(String.valueOf(sts13));
                break;
            case 2:
                sts12++;
                tex=(TextView) findViewById(R.id.textView25);
                tex.setText(String.valueOf(sts12));
                break;
            default: break;

        }
    }//increase the Nmber of Ships with the length i you can set by 1
    private void decrease(int i){
        TextView tex;
        switch (i){
            case 5:
                sts15--;
                tex=(TextView) findViewById(R.id.textView22);
                tex.setText(String.valueOf(sts15));
                break;
            case 4:
                sts14--;
                tex=(TextView) findViewById(R.id.textView23);
                tex.setText(String.valueOf(sts14));
                break;
            case 3:
                sts13--;
                tex=(TextView) findViewById(R.id.textView24);
                tex.setText(String.valueOf(sts13));
                break;
            case 2:
                sts12--;
                tex=(TextView) findViewById(R.id.textView25);
                tex.setText(String.valueOf(sts12));
                break;
            default: break;

        }
    }//decrease the Nmber of Ships with the length i you can set by 1
    private void InitializeImages() {

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        TextView tex= (TextView) findViewById(R.id.textView14);
        int fl=width*height;
        tex.setText(String.valueOf(fl));
        Button but= (Button) findViewById(R.id.button3);
        but.setText(String.valueOf(height));
        but= (Button) findViewById(R.id.button4);
        but.setText(String.valueOf(width));

        ImageView img;
        RelativeLayout.LayoutParams par;

        img=(ImageView) findViewById(R.id.imageView);
        img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.so, (int) (width * 0.12), (int) (height * 0.12)));
        img.setScaleType(ImageView.ScaleType.FIT_XY);

        img=(ImageView) findViewById(R.id.imageView2);
        img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.ko, (int) (width * 0.12), (int) (height * 0.12)));
        img.setScaleType(ImageView.ScaleType.FIT_XY);

        img=(ImageView) findViewById(R.id.imageView3);
        img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.zo, (int) (width * 0.12), (int) (height * 0.12)));
        img.setScaleType(ImageView.ScaleType.FIT_XY);

        img=(ImageView) findViewById(R.id.imageView4);
        img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.uo, (int) (width * 0.12), (int) (height * 0.12)));
        img.setScaleType(ImageView.ScaleType.FIT_XY);

        img=(ImageView) findViewById(R.id.imageView6);
        img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.ss, (int) (width * 19 / 72), (int) (height * 19 / 180)));
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        par = new RelativeLayout.LayoutParams((int)(width*0.95/18*5),(int)(height*0.93/9));
        img.setLayoutParams(par);

        img=(ImageView) findViewById(R.id.imageView7);
        img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.ks, (int) (width * 19 / 90), (int) (height * 19 / 180)));
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        par = new RelativeLayout.LayoutParams((int)(width*0.95/18*4),(int)(height*0.93/9));
        img.setLayoutParams(par);


        img=(ImageView) findViewById(R.id.imageView8);
        img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.zs, (int) (width * 19 / 120), (int) (height * 19 / 180)));
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        par = new RelativeLayout.LayoutParams((int)(width*0.95/18*3),(int)(height*0.93/9));
        img.setLayoutParams(par);


        img=(ImageView) findViewById(R.id.imageView9);
        img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.us, (int) (width * 19 / 180), (int) (height * 19 / 180)));
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        par = new RelativeLayout.LayoutParams((int)(width*0.95/18*2),(int)(height*0.93/9));
        img.setLayoutParams(par);


        img=(ImageButton) findViewById(R.id.imageButton);
        img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.rot, (int) (width * 0.12), (int) (height * 0.12)));
        img.setScaleType(ImageView.ScaleType.FIT_XY);

        img=(ImageView) findViewById(R.id.imageView10);
        img.setScaleType(ImageView.ScaleType.FIT_XY);}

    private void setListeners(){
        ImageView img= (ImageView) findViewById(R.id.imageView10);
        img.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;
                int height = size.y;
                final int action = event.getAction();
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        TextView tex;
                        decrease(((Shipdate) (event.getLocalState())).length);
                        return true;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        return true;

                    case DragEvent.ACTION_DRAG_LOCATION:
                        return true;

                    case DragEvent.ACTION_DRAG_EXITED:
                        return true;

                    case DragEvent.ACTION_DROP:
                        //First of all, lets check, if the Ship landed on a valid field.
                        //the field's size is 18x9, it takes 93%x95% of the total size (see content_singleplayergame.xml
                        //so we use the coordinates to know on which cell the ship would have landed
                        float x=event.getX();
                        float y=event.getY();
                        System.out.println(y);
                        System.out.println(x);
                        int xcord=(int)(x / 0.95 / width * 18);
                        int ycord=(int)(y / 0.93 / height * 9);
                        int s=p1.getField()[ycord][xcord];
                        if (s==2) increase(((Shipdate)(event.getLocalState())).length);
                        return true;

                    case DragEvent.ACTION_DRAG_ENDED:
                        if (!event.getResult()) increase(((Shipdate)(event.getLocalState())).length);
                        else{//now lets set a new ship on these coordinates. it has several eigenschaftens:
                            //1)Its long-clickable and then draggable
                            //2)As long as it collides with a prior set ship, it has a different color (prob. red)
                            //3) as long as at least one ship collides with another, the continue button is unclickable

                        }
                        return true;

                    default:
                        break;
                }

                return false;

            }
        });
        img=(ImageView) findViewById(R.id.imageView);
        img.setTag("Schlachts");
                img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (sts15 == 0) return true;
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;
                int height = size.y;
                ClipData.Item item = new ClipData.Item((String) v.getTag());
                ClipData dragdata = new ClipData((String) v.getTag(), new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
                ImageView imag = (ImageView) findViewById(R.id.imageView6);
                MyDragShadowBuilder meinShcatten = new MyDragShadowBuilder(imag, 2, 10);
                v.startDrag(dragdata, meinShcatten, new Shipdate(5,'h'), 0);
                return true;
            }
        });

        img=(ImageView) findViewById(R.id.imageView2);
        img.setTag("Kreuzers");
        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (sts14 == 0) return true;
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;
                int height = size.y;
                ClipData.Item item = new ClipData.Item((String) v.getTag());
                ClipData dragdata = new ClipData((String) v.getTag(), new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
                ImageView imag = (ImageView) findViewById(R.id.imageView7);
                MyDragShadowBuilder meinShcatten = new MyDragShadowBuilder(imag, 2, 8);
                v.startDrag(dragdata, meinShcatten, new Shipdate(4,'h'), 0);
                return true;
            }
        });


        img=(ImageView) findViewById(R.id.imageView3);
        img.setTag("Zerstos");

        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (sts13 == 0) return true;
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;
                int height = size.y;
                ClipData.Item item = new ClipData.Item((String) v.getTag());
                ClipData dragdata = new ClipData((String) v.getTag(), new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
                ImageView imag = (ImageView) findViewById(R.id.imageView8);
                MyDragShadowBuilder meinShcatten = new MyDragShadowBuilder(imag, 2, 6);
                v.startDrag(dragdata, meinShcatten, new Shipdate(3,'h'), 0);
                return true;
            }
        });

        img=(ImageView) findViewById(R.id.imageView4);
        img.setTag("Ubots");

        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (sts12 == 0) return true;
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;
                int height = size.y;
                ClipData.Item item= new ClipData.Item((String)v.getTag());
                ClipData dragdata= new ClipData((String)v.getTag(),new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},item);
                ImageView imag = (ImageView) findViewById(R.id.imageView9);
                MyDragShadowBuilder meinShcatten = new MyDragShadowBuilder(imag,2,4);
                v.startDrag(dragdata, meinShcatten, new Shipdate(2,'h'), 0);
                return true;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView img;
        super.onCreate(savedInstanceState);
        //how many ships remained to set
        setContentView(R.layout.activity_singleplayergame);
        Intent intent = getIntent();

        InitializeImages();
        InitializeSomething(intent);
        setListeners();
        int[] maxships=new int[4];
        maxships[0]=sts15;
        maxships[1]=sts14;
        maxships[2]=sts13;
        maxships[3]=sts12;
        p1=new Field(maxships);
//        img= new ImageView(ischthis);
//        LinearLayout.LayoutParams par = new LinearLayout.LayoutParams((int)(width*0.95/18*5),(int)(height*0.93/9));
//        img.setLayoutParams(par);
//        img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.schlachtashadow, (int) (width * 0.95 / 18 * 10), (int) (height * 0.93 / 9)));
//        img.setAdjustViewBounds(false);
//        img.setVisibility(View.VISIBLE);
//        img.setX((float) (width * 0.5));
//        img.setY((float) (height * 0.5));
//        img.setScaleType(ImageView.ScaleType.FIT_XY);
//        img.setId(R.id.imageView6);
//        RelativeLayout r= (RelativeLayout) findViewById(R.id.RelativeLayout);
//        r.addView(img);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

}
