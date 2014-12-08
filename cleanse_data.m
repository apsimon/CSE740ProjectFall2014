function new_data = cleanse_data(data)
    % For each row in the data set, the first column is 
    % the filer_id, the second column is the stock_id and the third
    % column is the number of different types of that stock the filer
    % holds. Need to transform the data so that the smallest value is a 0 and
    % make indices mapping new ids to original filer or stock id.
   
    % The return value is a cell containing the following:
    % 1 => transformed mapping
    % 2 => filer_id index
    % 3 => stock id index
    new_data = cell(3,1);
    
    s = size(data,1);
    transformed_mapping = zeros(s,2);
    
    % First do the filer ids
    filer_id_index = zeros(max(data(:,1)),2);
    filer_ids = data(:,1);
    
    index_value = 0;
    for i = 1:s
        next_value = filer_ids(i);
        % If the next filer id exists in the index, get its
        % value and write it in the transformed_mapping
        if filer_id_index(next_value,1) == 0
            % Put the value into the index and the transformed data
            filer_id_index(next_value,1) = next_value;
            filer_id_index(next_value,2) = index_value;
            transformed_mapping(i,1) = index_value;
            index_value = index_value + 1;
        else
            value = filer_id_index(next_value,2);
            transformed_mapping(i,1) = value;
        end
    end
    
    % Then do the stock ids
    stock_id_index = zeros(max(data(:,2)),2);
    stock_ids = data(:,2);

    for j = 1:s
        next_value = stock_ids(j);
        % If the next filer id exists in the index, get its
        % value and write it in the transformed_mapping
        if stock_id_index(next_value,1) == 0
            % Put the value into the index and the transformed data
            stock_id_index(next_value,1) = next_value;
            stock_id_index(next_value,2) = index_value;
            transformed_mapping(j,2) = index_value;
            index_value = index_value + 1;
        else
            value = stock_id_index(next_value,2);
            transformed_mapping(j,2) = value;
        end
    end
    
    new_data{1} = transformed_mapping;
    new_data{2} = filer_id_index;
    new_data{3} = stock_id_index;
end