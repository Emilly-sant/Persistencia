package cesar.school.emilly.test.ui.main.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import cesar.school.emilly.test.data.local.model.Favorite
import cesar.school.emilly.test.databinding.ItemCityFavoriteBinding

class FavoriteAdapter(
        private val onClickItem: (Favorite) -> Unit
): ListAdapter<Favorite, FavoriteAdapter.ViewHolder>(SearchDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCityFavoriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemCityFavoriteBinding) : RecyclerView.ViewHolder(
            binding.root
    ) {
        fun bind(favorite: Favorite) {
            binding.tvCityName.text = favorite.cityName
            binding.tvCountry.text = favorite.cityCountry
            binding.btnDeleteFavorite.setOnClickListener {
                onClickItem(favorite)
            }
        }
    }

    class SearchDiff : DiffUtil.ItemCallback<Favorite>() {
        override fun areItemsTheSame(oldItem: Favorite, newItem: Favorite) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Favorite, newItem: Favorite) = oldItem == newItem
    }
}


