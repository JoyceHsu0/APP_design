package com.example.booking_app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return 4;
    }
    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return Terrace_Room()
            }
            1 -> {
                return Oasis_Suite()
            }
            2 -> {
                return Family_Pool_Villa()
            }
            else -> {
                return Oasis_Villa()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Terrace Room"
            }
            1 -> {
                return "Oasis Suite"
            }
            2 -> {
                return "Family Pool Villa"
            }
            3 -> {
                return "Oasis Villa"
            }

        }
        return super.getPageTitle(position)
    }

    

}