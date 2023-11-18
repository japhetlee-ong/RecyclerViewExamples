package com.auf.cea.recyclerviewexamples.models.viewmodels

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.auf.cea.recyclerviewexamples.models.VeggiesModel

class VeggieViewModel : ViewModel() {

    private var veggiesList:MutableLiveData<List<VeggiesModel>>? = null

    internal fun getVeggiesList() : MutableLiveData<List<VeggiesModel>>{
        if(veggiesList == null){
            veggiesList = MutableLiveData()
            loadVeggies()
        }

        return veggiesList as MutableLiveData<List<VeggiesModel>>
    }

    private fun loadVeggies(){

        val vegList = ArrayList<VeggiesModel>()

        vegList.add(VeggiesModel("Carrot","Daucus carota"))
        vegList.add(VeggiesModel("Broccoli","Brassica oleracea"))
        vegList.add(VeggiesModel("Spinach","Spinacia oleracea"))
        vegList.add(VeggiesModel("Tomato", "Solanum lycopersicum"))
        vegList.add(VeggiesModel("Cucumber","Cucumis sativus"))

        veggiesList!!.value = vegList

    }

}