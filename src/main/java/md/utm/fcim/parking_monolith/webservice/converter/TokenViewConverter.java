package md.utm.fcim.parking_monolith.webservice.converter;

import com.google.common.base.Converter;
import md.utm.fcim.parking_monolith.business.dto.Token;
import md.utm.fcim.parking_monolith.webservice.view.TokenView;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 03/18/2018
 */
@Component
public class TokenViewConverter extends Converter<TokenView, Token> {

    @Override
    protected Token doForward(TokenView view) {
        return null;
    }

    @Override
    protected TokenView doBackward(Token dto) {
        TokenView view = new TokenView();
        view.setToken(dto.getToken());
        return view;
    }
}
