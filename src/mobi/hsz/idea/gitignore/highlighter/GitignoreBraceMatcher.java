package mobi.hsz.idea.gitignore.highlighter;

import com.intellij.codeInsight.highlighting.BraceMatcher;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import mobi.hsz.idea.gitignore.psi.GitignoreTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GitignoreBraceMatcher implements BraceMatcher {
    @Override
    public int getBraceTokenGroupId(IElementType tokenType) {
        return 1;
    }

    @Override
    public boolean isLBraceToken(HighlighterIterator iterator, CharSequence fileText, FileType fileType) {
        return GitignoreTypes.SBRACKET_LEFT.equals(iterator.getTokenType());
    }

    @Override
    public boolean isRBraceToken(HighlighterIterator iterator, CharSequence fileText, FileType fileType) {
        return GitignoreTypes.SBRACKET_RIGHT.equals(iterator.getTokenType());
    }

    @Override
    public boolean isPairBraces(IElementType tokenType, IElementType tokenType2) {
        return GitignoreTypes.SBRACKET_LEFT.equals(tokenType)
            && GitignoreTypes.SBRACKET_RIGHT.equals(tokenType2);
    }

    @Override
    public boolean isStructuralBrace(HighlighterIterator iterator, CharSequence text, FileType fileType) {
        return false;
    }

    @Nullable
    @Override
    public IElementType getOppositeBraceTokenType(@NotNull IElementType type) {
        return null;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
