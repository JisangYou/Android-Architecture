package com.example.jetpack.databinding;
import com.example.jetpack.R;
import com.example.jetpack.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.TextView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[0]
            );
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.root.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.sparse == variableId) {
            setSparse((android.util.SparseArray<java.lang.String>) variable);
        }
        else if (BR.index == variableId) {
            setIndex((int) variable);
        }
        else if (BR.list == variableId) {
            setList((java.util.List<java.lang.String>) variable);
        }
        else if (BR.key == variableId) {
            setKey((java.lang.String) variable);
        }
        else if (BR.map == variableId) {
            setMap((java.util.Map<java.lang.String,java.lang.String>) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSparse(@Nullable android.util.SparseArray<java.lang.String> Sparse) {
        this.mSparse = Sparse;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.sparse);
        super.requestRebind();
    }
    public void setIndex(int Index) {
        this.mIndex = Index;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.index);
        super.requestRebind();
    }
    public void setList(@Nullable java.util.List<java.lang.String> List) {
        this.mList = List;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.list);
        super.requestRebind();
    }
    public void setKey(@Nullable java.lang.String Key) {
        this.mKey = Key;
    }
    public void setMap(@Nullable java.util.Map<java.lang.String,java.lang.String> Map) {
        this.mMap = Map;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.map);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        android.util.SparseArray<java.lang.String> sparse = mSparse;
        java.lang.String sparseIndex = null;
        int index = mIndex;
        java.lang.String listIndex = null;
        java.lang.String mapTest1 = null;
        java.util.List<java.lang.String> list = mList;
        java.util.Map<java.lang.String,java.lang.String> map = mMap;

        if ((dirtyFlags & 0x23L) != 0) {
        }
        if ((dirtyFlags & 0x27L) != 0) {


            if ((dirtyFlags & 0x23L) != 0) {

                    if (sparse != null) {
                        // read sparse[index]
                        sparseIndex = sparse.get(index);
                    }
            }
        }
        if ((dirtyFlags & 0x26L) != 0) {



                if (list != null) {
                    // read list[index]
                    listIndex = getFromList(list, index);
                }
        }
        if ((dirtyFlags & 0x30L) != 0) {



                if (map != null) {
                    // read map["test1"]
                    mapTest1 = map.get("test1");
                }
        }
        // batch finished
        if ((dirtyFlags & 0x26L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, listIndex);
        }
        if ((dirtyFlags & 0x23L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, sparseIndex);
        }
        if ((dirtyFlags & 0x30L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, mapTest1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): sparse
        flag 1 (0x2L): index
        flag 2 (0x3L): list
        flag 3 (0x4L): key
        flag 4 (0x5L): map
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}