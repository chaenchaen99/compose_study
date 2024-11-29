    package com.example.movie_app.ui.util

    import android.graphics.Typeface
    import android.text.style.ForegroundColorSpan
    import android.text.style.StyleSpan
    import android.text.style.UnderlineSpan
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.remember
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.text.AnnotatedString
    import androidx.compose.ui.text.SpanStyle
    import androidx.compose.ui.text.buildAnnotatedString
    import androidx.compose.ui.text.font.FontStyle
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.style.TextDecoration
    import androidx.core.text.HtmlCompat


    /// HTML을 AnnotatedString으로 변환하는 기능.
    // HTML의 스타일 태그(굵게, 기울임, 색상, 밑줄)를 Compose UI에서 사용할 수 있는 스타일로 변환.
    // AnnotatedString은 Compose에서 텍스트 스타일을 적용하기 위해 사용하는 데이터 타입.
    @Composable
    fun getAnnotatedText(text: String): AnnotatedString {
        val spanned = remember(text) {
            HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
        return remember(spanned) {
            buildAnnotatedString {
                append(spanned.toString())
                spanned.getSpans(0, spanned.length, Any::class.java).forEach { span ->
                    val start = spanned.getSpanStart(span)
                    val end = spanned.getSpanEnd(span)
                    when (span) {
                        is StyleSpan -> when (span.style) {
                            Typeface.BOLD -> addStyle(
                                SpanStyle(fontWeight = FontWeight.Bold),
                                start,
                                end
                            )

                            Typeface.ITALIC -> addStyle(
                                SpanStyle(fontStyle = FontStyle.Italic),
                                start,
                                end
                            )

                            Typeface.BOLD_ITALIC -> addStyle(
                                SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Italic,
                                ),
                                start,
                                end,
                            )
                        }

                        is UnderlineSpan -> addStyle(
                            SpanStyle(textDecoration = TextDecoration.Underline),
                            start,
                            end
                        )

                        is ForegroundColorSpan -> addStyle(
                            SpanStyle(color = Color(span.foregroundColor)),
                            start,
                            end
                        )
                    }
                }
            }
        }
    }
