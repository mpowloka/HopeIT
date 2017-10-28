package org.hopeit.charapp.fragments;


import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.AnyRes;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.hopeit.charapp.R;
import org.hopeit.charapp.utils.Fundraising;

import java.util.List;


public class FundraisingFragment extends Fragment {


    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static FundraisingFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FundraisingFragment fragment = new FundraisingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fundraising, container, false);
        TextView textView = (TextView) view.findViewById(R.id.content);
        return view;
    }


    private Uri uriToDrawable(@NonNull Context context, @AnyRes int drawableId) {
        Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + context.getResources().getResourcePackageName(drawableId)
                + '/' + context.getResources().getResourceTypeName(drawableId)
                + '/' + context.getResources().getResourceEntryName(drawableId));
        return imageUri;
    }

    private class FundraisingAdapter extends
            RecyclerView.Adapter<FundraisingAdapter.ViewHolder> {

        private List<Fundraising> fundraisingList;
        private Context context;

        public FundraisingAdapter(List<Fundraising> fundraisingList) {
            this.fundraisingList = fundraisingList;
            this.context = FundraisingFragment.this.getActivity();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View fundraisingView = inflater.inflate(R.layout.item_fundraising, parent, false);
            FundraisingAdapter.ViewHolder viewHolder = new FundraisingAdapter.ViewHolder(fundraisingView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Fundraising fundraising = fundraisingList.get(position);

            CardView card = holder.card;
            // TODO
/*            TextView textContentView = holder.textContentView;
            textContentView.setText(fundraising.getTextContent());
            ImageView imageContentView = holder.imageContentView;
            imageContentView.setImageURI(fundraising.getImageContent());*/
        }

        @Override
        public int getItemCount() {
            return fundraisingList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            private CardView card;
            private ConstraintLayout container;
            private TextView textContentView;
            private ImageView imageContentView;

            private ViewHolder(View itemView) {
                super(itemView);
                card = (CardView) itemView.findViewById(R.id.card);
                textContentView = (TextView) itemView.findViewById(R.id.text_content);
                imageContentView = (ImageView) itemView.findViewById(R.id.image_content);
            }
        }

    }
}
