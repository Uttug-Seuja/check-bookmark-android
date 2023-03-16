package com.o2.check_bookmark_android.ui.booksummary.bottom

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.o2.check_bookmark_android.R

class BottomBookSummaryMore(
    val callback: (type: BookSummaryMoreType) -> Unit
) : BottomSheetDialogFragment(){
    private lateinit var dlg : BottomSheetDialog

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // 이 코드를 실행하지 않으면 XML에서 round 처리를 했어도 적용되지 않는다.
        dlg = ( super.onCreateDialog(savedInstanceState).apply {
            // window?.setDimAmount(0.2f) // Set dim amount here
            setOnShowListener {
                val bottomSheet = findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
                bottomSheet.setBackgroundResource(android.R.color.transparent)

                val behavior = BottomSheetBehavior.from(bottomSheet)
                behavior.isDraggable = true
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        } ) as BottomSheetDialog
        return dlg
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.dialog_bottom_book_summary_more, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val boast = requireView().findViewById<TextView>(R.id.boast_btn)
        val delete = requireView().findViewById<TextView>(R.id.delete_btn)
        val close = requireView().findViewById<TextView>(R.id.close_btn)

        boast.setOnClickListener {
            callback.invoke(BookSummaryMoreType.Boast)
            dismiss()
        }
        delete.setOnClickListener {
            callback.invoke(BookSummaryMoreType.Delete)
            dismiss()
        }
        close.setOnClickListener {
            dismiss()
        }
    }
}

sealed class BookSummaryMoreType {
    object Boast: BookSummaryMoreType()
    object Delete: BookSummaryMoreType()
}

