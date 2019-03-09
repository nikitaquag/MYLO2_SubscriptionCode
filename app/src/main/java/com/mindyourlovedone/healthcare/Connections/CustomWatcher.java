package com.mindyourlovedone.healthcare.Connections;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

public class CustomWatcher  implements TextWatcher
{
    private Object item;
    Context context;
    int prevL = 0;
    public CustomWatcher(Object item, Context context)
    {
        this.item = item;
        this.context=context;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
    {
        prevL = charSequence.length();
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
    {

    }

    @Override
    public void afterTextChanged(Editable editable)
    {

        int length = editable.length();
        Toast.makeText(context,prevL+"-"+length,Toast.LENGTH_SHORT).show();
        if ((prevL < length) && (length == 3 || length == 7)) {
            editable.append("-");
        }

    }
}
