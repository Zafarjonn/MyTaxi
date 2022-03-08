package uz.zafarbek.main.ui.enums


import uz.zafarbek.main.R


enum class SettingsItems(val nextText: String? = null, val text: Int?) {
    ABOUT_APP(null, R.string.about_app),
    ABOUT_ORG(null,R.string.about_org),
    VERSION("1.0",R.string.version),
    SEPARATOR("",null),
    FEEDBACK(null,R.string.feedback),
    RATE_APP(null, R.string.rate_app),
    TERMS_OF_USE(null, R.string.terms_of_use_title)

//    companion object {
//        val SettingsItems.text: String
//            get() = context.resources.getStringArray(R.array.setting)[ordinal]
//    }
}