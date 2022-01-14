package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartResponseMapper
        implements DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setId(shoppingCart.getId());
        List<Long> ticketIds = shoppingCart.getTickets().stream()
                .map(t -> t.getId())
                .collect(Collectors.toList());
        shoppingCartResponseDto.setTicketIds(ticketIds);
        return shoppingCartResponseDto;
    }
}
