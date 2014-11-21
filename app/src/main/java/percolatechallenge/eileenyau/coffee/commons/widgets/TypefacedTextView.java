package percolatechallenge.eileenyau.coffee.commons.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import percolatechallenge.eileenyau.coffee.R;
import percolatechallenge.eileenyau.coffee.util.FontType;
import percolatechallenge.eileenyau.coffee.util.TypefaceHelper;

public class TypefacedTextView extends TextView {

    public TypefacedTextView(Context context) {
        super(context);
        init(null);
    }

    public TypefacedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TypefacedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (!isInEditMode()) {
            TypedArray styledAttrs = getContext()
                    .obtainStyledAttributes(attrs, R.styleable.TypefacedTextView);
            int fontIntValue = styledAttrs.getInt(R.styleable.TypefacedTextView_fontName,
                    FontType.ROBOTO_REGULAR.ordinal());
            styledAttrs.recycle();

            FontType font = FontType.values()[fontIntValue];
            setTypeface(font);
        }
    }

    public void setTypeface(FontType font) {
        Typeface typeface = TypefaceHelper
                .get(getContext(), "fonts/" + font.getFileName());
        setTypeface(typeface);
    }
}